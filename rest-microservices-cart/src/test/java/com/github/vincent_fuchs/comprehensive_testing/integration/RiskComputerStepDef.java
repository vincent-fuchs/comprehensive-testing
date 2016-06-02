package com.github.vincent_fuchs.comprehensive_testing.integration;

import com.github.vincent_fuchs.comprehensive_testing.AllServicesTest;
import com.github.vincent_fuchs.comprehensive_testing.CartRestfulApp;
import com.github.vincent_fuchs.comprehensive_testing.unit.model.ComputedRisk;
import com.github.vincent_fuchs.comprehensive_testing.unit.model.ProductWithVolatilityIndex;
import com.google.common.collect.ImmutableMap;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static com.github.vincent_fuchs.comprehensive_testing.AllServicesTest.*;

@ContextConfiguration(name = "cart-service", classes = CartRestfulApp.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
@EnableFeignClients
public class RiskComputerStepDef {

    private Map<String, String> computedRisks = new HashMap<>();
    private List<String> productsIamInterestedIn = new ArrayList<>();
    private RestTemplate restTemplate;

    @Before
    public void all_my_services_are_started() throws Throwable {
        initRegistryServer();
        restTemplate = new TestRestTemplate();
    }


    @Given("^the rating associated to the countries are as follows :$")
    public void the_rating_associated_to_the_countries_are_as_follows(DataTable arg1) throws Throwable {
        initCountryServer();
    }

    @Given("^I am interested in these products :$")
    public void i_am_interested_in_these_products(List<ProductWithVolatilityIndex> products) throws Throwable {
        initProductServer();
        initVolatilityIndexServer();
        waitForFewSecondsForAutoRegistration();
        productsIamInterestedIn.addAll(products.stream().map(ProductWithVolatilityIndex::getName).collect(Collectors.toList()));
    }

    private void waitForFewSecondsForAutoRegistration() throws InterruptedException {
        Thread.sleep(30000);
    }

    @When("^I add them in my portfolio$")
    public void i_add_them_in_my_portfolio() throws Throwable {
        for (String productNameIadd : productsIamInterestedIn) {
            ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:6060/cart/add/{product}", String.class, productNameIadd);
            computedRisks.put(productNameIadd, result.getBody());
        }
    }

    @Then("^the products are allocated in these risk buckets :$")
    public void the_products_are_allocated_in_these_risk_buckets(List<ComputedRisk> expectedComputedRisksAsString) throws Throwable {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        for (ComputedRisk computedRisk : expectedComputedRisksAsString) {
            builder.put(computedRisk.getProductName(), computedRisk.getRiskBucket());
        }
        Assertions.assertThat(computedRisks).containsAllEntriesOf(builder.build());
    }

    @After
    public static void destroyServers() {
        AllServicesTest.destroyServers();
    }
}
