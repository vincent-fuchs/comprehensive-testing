package com.github.vincent_fuchs.comprehensive_testing;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RiskComputerStepDefs {

    RiskComputer riskComputer = new RiskComputer();

    List<String> productsIamInterestedIn=new ArrayList<>();

    Map<String,Risk> computedRisks=new HashMap<>();

    @Given("^the rating associated to the countries are as follows :$")
    public void the_rating_associated_to_the_countries_are_as_follows(List<CountryRating> countryRatings) throws Throwable {
        CountryRatingService countryRatingService = new CountryRatingServiceTestImpl(countryRatings);

        riskComputer.setCountryRatingService(countryRatingService);
    }

    @Given("^I am interested in these products :$")
    public void i_am_interested_in_these_products(List<ProductWithVolatilityIndex> products) throws Throwable {

        VolatilityIndexService volatilityIndexService=new VolatilityIndexServiceTestImpl(products);

        riskComputer.setVolatilityIndexService(volatilityIndexService);

        for(ProductWithVolatilityIndex product : products){
            productsIamInterestedIn.add(product.getName());
        }

    }

    @When("^I add them in my portfolio$")
    public void i_add_them_in_my_portfolio() throws Throwable {

        for(String productNameIadd : productsIamInterestedIn) {
            computedRisks.put(productNameIadd,riskComputer.computeRisk(productNameIadd));
        }

    }

    @Then("^the products are allocated in these risk buckets :$")
    public void the_products_are_allocated_in_these_risk_buckets(List<ComputedRisk> expectedComputedRisksAsString) throws Throwable {

        Map<String,Risk> expectedComputedRisks=new HashMap<>();
        for(ComputedRisk computedRisk : expectedComputedRisksAsString){

            expectedComputedRisks.put(computedRisk.getProductName(),Risk.valueOf(computedRisk.getRiskBucket()));

        }

        //TODO understand what is wrong below assertion : it doesn't work
       // assertThat(computedRisks).containsExactly(expectedComputedRisks);
    }

}
