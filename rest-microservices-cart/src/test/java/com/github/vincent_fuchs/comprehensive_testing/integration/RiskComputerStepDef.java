package com.github.vincent_fuchs.comprehensive_testing.integration;

import com.github.vincent_fuchs.comprehensive_testing.AllServicesTest;
import com.github.vincent_fuchs.comprehensive_testing.CartRestfulApp;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CartRestfulApp.class, loader = SpringApplicationContextLoader.class)
public class RiskComputerStepDef {

    @Before
    public void all_my_services_are_started() throws Throwable {
        AllServicesTest.initRegistryServer();
    }


    @Given("^the rating associated to the countries are as follows :$")
    public void the_rating_associated_to_the_countries_are_as_follows(DataTable arg1) throws Throwable {
        // TODO
    }

    @Given("^I am interested in these products :$")
    public void i_am_interested_in_these_products(DataTable arg1) throws Throwable {
        // TODO
    }

    @When("^I add them in my portfolio$")
    public void i_add_them_in_my_portfolio() throws Throwable {
        // TODO
    }

    @Then("^the products are allocated in these risk buckets :$")
    public void the_products_are_allocated_in_these_risk_buckets(DataTable arg1) throws Throwable {
        // TODO
    }

    @After
    public static void destroyServers() {
        AllServicesTest.destroyServers();
    }
}
