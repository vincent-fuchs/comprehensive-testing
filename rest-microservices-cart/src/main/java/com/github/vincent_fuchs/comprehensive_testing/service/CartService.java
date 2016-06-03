package com.github.vincent_fuchs.comprehensive_testing.service;

import com.github.vincent_fuchs.comprehensive_testing.model.CountryRating;
import com.github.vincent_fuchs.comprehensive_testing.model.Risk;
import com.github.vincent_fuchs.comprehensive_testing.model.VolatilityIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static com.github.vincent_fuchs.comprehensive_testing.model.Risk.*;
import static com.github.vincent_fuchs.comprehensive_testing.model.VolatilityIndex.*;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Service
public class CartService {

    @Autowired
    private CountryService countryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private VolatilityIndexService volatilityIndexService;


    public String getProductRisk(String productName) {
        String productCountry = productService.getProductCountry(productName);
        CountryRating countryRating = countryService.getRating(productCountry);
        return countryRating.isShouldOverride() ? computeCountryRisk(countryRating).toString() : getRiskBucket(productName, countryRating);
    }

    private String getRiskBucket(String productName, CountryRating countryRating) {
        String productVolatilityIndex = volatilityIndexService.getProductVolatilityIndex(productName);
        Risk volatilityIndexRisk = computeVolatilityIndexRisk(productVolatilityIndex);
        Risk countryRisk = computeCountryRisk(countryRating);
        return Risk.max(volatilityIndexRisk,countryRisk).toString();
    }

    private Risk computeCountryRisk(CountryRating countryRating) {
        return getCountryRiskRating().get(countryRating.getRating());
    }

    private Risk computeVolatilityIndexRisk(String productVolatilityIndex) {
        return getVolatilityIndexRiskRating().get(VolatilityIndex.getEnum(productVolatilityIndex));
    }

    private Map<VolatilityIndex, Risk> getVolatilityIndexRiskRating() {
        Map<VolatilityIndex, Risk> volatilityIndexRiskRating = new EnumMap<>(VolatilityIndex.class);
        volatilityIndexRiskRating.put(A, HIGH);
        volatilityIndexRiskRating.put(B, HIGH);
        volatilityIndexRiskRating.put(C, MEDIUM);
        volatilityIndexRiskRating.put(D, MEDIUM);
        volatilityIndexRiskRating.put(E, LOW);
        return volatilityIndexRiskRating;
    }

    private Map<Integer, Risk> getCountryRiskRating() {
        Map<Integer, Risk> countryRiskRating = new HashMap<>();
        countryRiskRating.put(1, HIGH);
        countryRiskRating.put(2, MEDIUM);
        countryRiskRating.put(3, MEDIUM);
        countryRiskRating.put(4, LOW);
        countryRiskRating.put(5, LOW);
        return countryRiskRating;
    }
}
