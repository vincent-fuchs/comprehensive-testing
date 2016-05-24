package com.github.vincent_fuchs.comprehensive_testing;

import lombok.Data;

@Data
public class Product {

    private String name;

    private String issuingCountry;

    public Product(String name, String issuingCountry) {

        this.name=name;
        this.issuingCountry=issuingCountry;

    }
}
