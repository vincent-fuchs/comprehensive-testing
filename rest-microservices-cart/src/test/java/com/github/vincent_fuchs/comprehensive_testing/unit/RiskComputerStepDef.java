package com.github.vincent_fuchs.comprehensive_testing.unit;

import com.github.vincent_fuchs.comprehensive_testing.model.Product;
import com.github.vincent_fuchs.comprehensive_testing.service.CartService;
import com.github.vincent_fuchs.comprehensive_testing.model.ComputedRisk;
import com.github.vincent_fuchs.comprehensive_testing.model.CountryRating;
import com.github.vincent_fuchs.comprehensive_testing.service.CountryService;
import com.github.vincent_fuchs.comprehensive_testing.service.ProductService;
import com.github.vincent_fuchs.comprehensive_testing.service.VolatilityIndexService;
import com.github.vincent_fuchs.comprehensive_testing.model.ProductWithVolatilityIndex;
import com.google.common.collect.ImmutableMap;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.*;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RiskComputerStepDef {

    private Map<String, String> computedRisks = new HashMap<>();
    private List<String> productsIamInterestedIn = new ArrayList<>();

    @InjectMocks
    private CartService cartService;

    @Mock
    private CountryService countryService;

    @Mock
    private ProductService productService;

    @Mock
    private VolatilityIndexService volatilityIndexService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Given("^the rating associated to the countries are as follows :$")
    public void the_rating_associated_to_the_countries_are_as_follows(List<CountryRating> countryRatings) throws Throwable {
        final Map<String, CountryRating> countryMapping = new HashMap<>();
        for (CountryRating countryCodeRating : countryRatings) {
            countryMapping.put(countryCodeRating.getCountryCode(),countryCodeRating);
        }
        Mockito.when(countryService.getRating(Matchers.anyString())).thenAnswer((Answer<CountryRating>) invocation -> {
            Object[] args = invocation.getArguments();
            return countryMapping.get((String) args[0]);
        });
    }

    @Given("^I am interested in these products :$")
    public void i_am_interested_in_these_products(List<ProductWithVolatilityIndex> products) throws Throwable {
        productsIamInterestedIn.addAll(products.stream().map(ProductWithVolatilityIndex::getName).collect(Collectors.toList()));
        final Map<String, Product> productIssuingCountryMapping = new HashMap<>();
        final Map<String, ProductWithVolatilityIndex> volatilityIndexMapping = new HashMap<>();
        for (ProductWithVolatilityIndex productWithVolatilityIndex : products) {
            productIssuingCountryMapping.put(productWithVolatilityIndex.getName(), new Product(productWithVolatilityIndex.getName(), productWithVolatilityIndex.getIssuingCountry()));
            volatilityIndexMapping.put(productWithVolatilityIndex.getName(), productWithVolatilityIndex);
        }
        Mockito.when(productService.getProductCountry(Matchers.anyString())).thenAnswer((Answer<String>) invocation -> {
            Object[] args = invocation.getArguments();
            return productIssuingCountryMapping.get((String) args[0]).getCountryCode();
        });
        Mockito.when(volatilityIndexService.getProductVolatilityIndex(Matchers.anyString())).thenAnswer((Answer<String>) invocation -> {
            Object[] args = invocation.getArguments();
            return volatilityIndexMapping.get((String) args[0]).getVolatilityIndex();
        });
    }

    @When("^I add them in my portfolio$")
    public void i_add_them_in_my_portfolio() throws Throwable {
        for (String productNameIadd : productsIamInterestedIn) {
            computedRisks.put(productNameIadd, cartService.getProductRisk(productNameIadd));
        }
    }

    @Then("^the products are allocated in these risk buckets :$")
    public void the_products_are_allocated_in_these_risk_buckets(List<ComputedRisk> expectedComputedRisksAsString) throws Throwable {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        for (ComputedRisk computedRisk : expectedComputedRisksAsString) {
            builder.put(computedRisk.getProductName(), computedRisk.getRiskBucket());
        }
        assertThat(computedRisks).containsAllEntriesOf(builder.build());
    }
}
