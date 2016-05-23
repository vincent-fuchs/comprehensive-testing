package com.github.vincent_fuchs.comprehensive_testing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VolatilityIndexServiceTestImpl implements VolatilityIndexService {

    Map<String,Character> volatilityByProduct=new HashMap<>();

    public VolatilityIndexServiceTestImpl(List<ProductWithVolatilityIndex> products) {

        for(ProductWithVolatilityIndex product : products){
            volatilityByProduct.put(product.getName(),product.getVolatilityIndex());
        }
    }

    @Override
    public char getVolatilityIndexForProduct(String productName) {
        return volatilityByProduct.get(productName);
    }
}
