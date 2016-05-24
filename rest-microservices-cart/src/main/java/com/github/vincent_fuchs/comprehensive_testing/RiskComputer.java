package com.github.vincent_fuchs.comprehensive_testing;


import java.util.HashMap;
import java.util.Map;

import static com.github.vincent_fuchs.comprehensive_testing.Risk.*;

public class RiskComputer {
    private CountryRatingService countryRatingService;
    private VolatilityIndexService volatilityIndexService;


    private ProductService productService;

    private Map<VolatilityIndex, Risk> volatilityIndexRiskRating;
    private Map<Integer, Risk> countryRiskRating;

    public RiskComputer() {
        initVolitalityIndexRiskRating();
        initCountryRiskRating();
    }

    private void initCountryRiskRating() {
        countryRiskRating = new HashMap<>();
        countryRiskRating.put(1, HIGH);
        countryRiskRating.put(2, MEDIUM);
        countryRiskRating.put(3, MEDIUM);
        countryRiskRating.put(4, LOW);
        countryRiskRating.put(5, LOW);
    }

    private void initVolitalityIndexRiskRating() {
        volatilityIndexRiskRating = new HashMap<>();
        volatilityIndexRiskRating.put(VolatilityIndex.A, HIGH);
        volatilityIndexRiskRating.put(VolatilityIndex.B, HIGH);
        volatilityIndexRiskRating.put(VolatilityIndex.C, MEDIUM);
        volatilityIndexRiskRating.put(VolatilityIndex.D, LOW);
        volatilityIndexRiskRating.put(VolatilityIndex.E, LOW);
    }

    public void setCountryRatingService(CountryRatingService countryRatingService) {
        this.countryRatingService = countryRatingService;
    }

    public void setVolatilityIndexService(VolatilityIndexService volatilityIndexService) {
        this.volatilityIndexService = volatilityIndexService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Risk computeRisk(String productNameIadd) {
        Product product = productService.getProductFromName(productNameIadd);
        VolatilityIndex volatilityIndexForProduct = volatilityIndexService.getVolatilityIndexForProduct(productNameIadd);
        CountryRating countryRating = countryRatingService.getRating(product.getIssuingCountry());
        return countryRating.isShouldOverride() ? countryRiskRating.get(countryRating.getRating()) : getRiskBucket(countryRating, volatilityIndexForProduct);
    }

    private Risk getRiskBucket(CountryRating countryRating, VolatilityIndex volatilityIndexForProduct) {
        Risk volatilityIndexRisk = volatilityIndexRiskRating.get(volatilityIndexForProduct);
        Risk countryRisk = countryRiskRating.get(countryRating.getRating());
        // TODO : refactor
        return HIGH == volatilityIndexRisk || HIGH == countryRisk ? HIGH : (MEDIUM == volatilityIndexRisk || MEDIUM == countryRisk ? MEDIUM : LOW);
    }
}
