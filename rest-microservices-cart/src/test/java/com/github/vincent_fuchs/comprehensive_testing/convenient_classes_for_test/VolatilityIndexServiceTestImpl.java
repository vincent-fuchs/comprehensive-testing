package com.github.vincent_fuchs.comprehensive_testing.convenient_classes_for_test;

import com.github.vincent_fuchs.comprehensive_testing.VolatilityIndex;
import com.github.vincent_fuchs.comprehensive_testing.VolatilityIndexService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VolatilityIndexServiceTestImpl implements VolatilityIndexService {

    private Map<String, VolatilityIndex> volatilityByProduct = new HashMap<>();

    public VolatilityIndexServiceTestImpl(List<ProductWithVolatilityIndex> products) {
        for (ProductWithVolatilityIndex product : products) {
            volatilityByProduct.put(product.getName(), VolatilityIndex.valueOf(product.getVolatilityIndex()));
        }
    }

    @Override
    public VolatilityIndex getVolatilityIndexForProduct(String productName) {
        return volatilityByProduct.get(productName);
    }
}
