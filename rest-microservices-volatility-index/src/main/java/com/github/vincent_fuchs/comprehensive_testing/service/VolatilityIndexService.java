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
public class VolatilityIndexService {
    private static Map<String, String> productAndVolatilityIndex = new HashMap<>();

    static {
        productAndVolatilityIndex.put("ISIN123", "A");
        productAndVolatilityIndex.put("ISIN456", "C");
        productAndVolatilityIndex.put("ISIN789", "E");
        productAndVolatilityIndex.put("ISIN987", "B");
        productAndVolatilityIndex.put("ISIN654", "D");
        productAndVolatilityIndex.put("ISIN321", "E");
        productAndVolatilityIndex.put("ISIN741", "A");
        productAndVolatilityIndex.put("ISIN852", "D");
        productAndVolatilityIndex.put("ISIN963", "E");
        productAndVolatilityIndex.put("ISIN147", "A");
        productAndVolatilityIndex.put("ISIN258", "C");
        productAndVolatilityIndex.put("ISIN369", "E");
        productAndVolatilityIndex.put("ISIN753", "B");
        productAndVolatilityIndex.put("ISIN159", "D");
        productAndVolatilityIndex.put("ISIN951", "E");
        productAndVolatilityIndex.put("ISIN357", "A");
        productAndVolatilityIndex.put("ISIN486", "D");
        productAndVolatilityIndex.put("ISIN426", "E");
    }

    public String getProductVolatilityIndex(String productName) {
        return productAndVolatilityIndex.get(productName);
    }
}
