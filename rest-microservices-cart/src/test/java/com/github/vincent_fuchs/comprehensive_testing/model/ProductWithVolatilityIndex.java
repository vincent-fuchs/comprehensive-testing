package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;

@Data
public class ProductWithVolatilityIndex {

    private String volatilityIndex;

    private String name;

    private String issuingCountry;

    public ProductWithVolatilityIndex(String name,String issuingCountry, String volatilityIndex){
        this.name=name;
        this.issuingCountry=issuingCountry;
        this.volatilityIndex=volatilityIndex;
    }
}
