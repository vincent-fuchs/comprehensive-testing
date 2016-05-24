package com.github.vincent_fuchs.comprehensive_testing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VolatilityIndexServiceTestImpl implements VolatilityIndexService {

    private Map<String, ProductWithVolatilityIndex> volatilityByProduct = new HashMap<>();

    public VolatilityIndexServiceTestImpl(List<ProductWithVolatilityIndex> products) {
        for (ProductWithVolatilityIndex product : products) {
            volatilityByProduct.put(product.getName(), product);
        }
    }

    @Override
    public ProductWithVolatilityIndex getVolatilityIndexForProduct(String productName) {
        return volatilityByProduct.get(productName);
    }
}
