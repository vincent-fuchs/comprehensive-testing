// FIXME :
//package com.github.vincent_fuchs.comprehensive_testing.unit;
//
//import com.github.vincent_fuchs.comprehensive_testing.model.CountryRating;
//import com.github.vincent_fuchs.comprehensive_testing.Product;
//import com.github.vincent_fuchs.comprehensive_testing.unit.model.ComputedRisk;
//import com.github.vincent_fuchs.comprehensive_testing.convenient_classes_for_test.ProductWithVolatilityIndex;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
///*
//This class is here just to show that BDD scenarios are not mandatory :
//from a coverage perspective, this is exactly the same as the other unit test using the scenario.
//But here, since we're not using a plain text file as a communication medium, the developer is "on his own"
// */
//public class PureJunitNoBDDTest {
//
//    RiskComputerStepDef riskComputerStepDef=new RiskComputerStepDef();
//
//    @Test
//    public void sameTestAsBDD() throws Throwable {
//
//        List<CountryRating> countryRatings=new ArrayList<>();
//        countryRatings.add(new CountryRating("FRA",1,false));
//        countryRatings.add(new CountryRating("USA",2,false));
//        countryRatings.add(new CountryRating("JAP",4,false));
//        countryRatings.add(new CountryRating("IND",3,true));
//        countryRatings.add(new CountryRating("GER",1,true));
//        countryRatings.add(new CountryRating("ITA",5,true));
//
//        riskComputerStepDef.the_rating_associated_to_the_countries_are_as_follows(countryRatings);
//
//        List<ProductWithVolatilityIndex> products=new ArrayList<>();
//
//        products.add(new ProductWithVolatilityIndex("ISIN123","FRA","A"));
//        products.add(new ProductWithVolatilityIndex("ISIN456","FRA","C"));
//        products.add(new ProductWithVolatilityIndex("ISIN789","FRA","E"));
//        products.add(new ProductWithVolatilityIndex("ISIN987","USA","B"));
//        products.add(new ProductWithVolatilityIndex("ISIN654","USA","D"));
//        products.add(new ProductWithVolatilityIndex("ISIN321","USA","E"));
//        products.add(new ProductWithVolatilityIndex("ISIN741","JAP","A"));
//        products.add(new ProductWithVolatilityIndex("ISIN852","JAP","D"));
//
//        products.add(new ProductWithVolatilityIndex("ISIN963","JAP","E"));
//        products.add(new ProductWithVolatilityIndex("ISIN147","GER","A"));
//        products.add(new ProductWithVolatilityIndex("ISIN258","GER","C"));
//        products.add(new ProductWithVolatilityIndex("ISIN369","GER","E"));
//        products.add(new ProductWithVolatilityIndex("ISIN753","IND","B"));
//        products.add(new ProductWithVolatilityIndex("ISIN159","IND","D"));
//        products.add(new ProductWithVolatilityIndex("ISIN951","IND","E"));
//        products.add(new ProductWithVolatilityIndex("ISIN357","ITA","A"));
//        products.add(new ProductWithVolatilityIndex("ISIN486","ITA","D"));
//        products.add(new ProductWithVolatilityIndex("ISIN426","ITA","E"));
//
//        riskComputerStepDef.i_am_interested_in_these_products(products);
//
//        riskComputerStepDef.i_add_them_in_my_portfolio();
//
//        List<ComputedRisk> expectedComputedRisks=new ArrayList<>();
//        expectedComputedRisks.add(new ComputedRisk("ISIN123","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN456","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN789","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN987","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN654","MEDIUM"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN321","MEDIUM"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN741","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN852","MEDIUM"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN963","LOW"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN147","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN258","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN369","HIGH"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN753","MEDIUM"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN159","MEDIUM"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN951","MEDIUM"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN357","LOW"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN486","LOW"));
//        expectedComputedRisks.add(new ComputedRisk("ISIN426","LOW"));
//
//        riskComputerStepDef.the_products_are_allocated_in_these_risk_buckets(expectedComputedRisks);
//
//    }
//
//
//
//
//}
