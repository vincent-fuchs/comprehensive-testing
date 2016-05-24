package com.github.vincent_fuchs.comprehensive_testing.convenient_classes_for_test;

import com.github.vincent_fuchs.comprehensive_testing.Product;
import lombok.Data;

@Data
public class ProductWithVolatilityIndex extends Product {
    private String volatilityIndex;

    public ProductWithVolatilityIndex(String name, String issuingCountry){
        super(name,issuingCountry);
    }
}
