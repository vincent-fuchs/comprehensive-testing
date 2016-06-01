package com.github.vincent_fuchs.comprehensive_testing.unit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/addProductInPortfolio.feature",
        strict = true, glue = "classpath:com/github/vincent_fuchs/comprehensive_testing/unit",
        tags = "@UnitTest")
public class RiskComputerTest {

}
