package com.github.vincent_fuchs.comprehensive_testing.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Service
public class ProductService {

    private static Map<String, String> productAndIssuingCountry = new HashMap<>();

    static {
        productAndIssuingCountry.put("ISIN123", "FRA");
        productAndIssuingCountry.put("ISIN456", "FRA");
        productAndIssuingCountry.put("ISIN789", "FRA");
        productAndIssuingCountry.put("ISIN987", "USA");
        productAndIssuingCountry.put("ISIN654", "USA");
        productAndIssuingCountry.put("ISIN321", "USA");
        productAndIssuingCountry.put("ISIN741", "JAP");
        productAndIssuingCountry.put("ISIN852", "JAP");
        productAndIssuingCountry.put("ISIN963", "JAP");
        productAndIssuingCountry.put("ISIN147", "GER");
        productAndIssuingCountry.put("ISIN258", "GER");
        productAndIssuingCountry.put("ISIN369", "GER");
        productAndIssuingCountry.put("ISIN753", "IND");
        productAndIssuingCountry.put("ISIN159", "IND");
        productAndIssuingCountry.put("ISIN951", "IND");
        productAndIssuingCountry.put("ISIN357", "ITA");
        productAndIssuingCountry.put("ISIN486", "ITA");
        productAndIssuingCountry.put("ISIN426", "ITA");
    }

    public String getProductCountry(String productName) {
        return productAndIssuingCountry.get(productName);
    }
}
