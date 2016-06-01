package com.github.vincent_fuchs.comprehensive_testing.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/addProductInPortfolio.feature",
        strict = true, glue = "classpath:com/github/vincent_fuchs/comprehensive_testing/integration",
        tags = "@IntegrationTest")
public class RiskComputerTest {

}
