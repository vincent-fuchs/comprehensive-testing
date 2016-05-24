package com.github.vincent_fuchs.comprehensive_testing.convenient_classes_for_test;

import com.github.vincent_fuchs.comprehensive_testing.Product;
import com.github.vincent_fuchs.comprehensive_testing.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceTestImpl implements ProductService {

    Map<String,Product> products=new HashMap<>();

    public ProductServiceTestImpl(List<ProductWithVolatilityIndex> productsFromScenario) {

        for(ProductWithVolatilityIndex product : productsFromScenario){
            products.put(product.getName(),new Product(product.getName(),product.getIssuingCountry()));

        }


    }

    @Override
    public Product getProductFromName(String productName) {
        return products.get(productName);
    }
}
