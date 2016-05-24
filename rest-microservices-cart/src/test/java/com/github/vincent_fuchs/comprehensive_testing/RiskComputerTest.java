package com.github.vincent_fuchs.comprehensive_testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/addProductInPortfolio.feature",
        strict = true)
public class RiskComputerTest {

}
