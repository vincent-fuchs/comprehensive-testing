package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Data
public class Product {
    private String productName;
    private String countryCode;

    public Product() {
        super();
    }

    public Product(String productName, String countryCode) {
        setProductName(productName);
        setCountryCode(countryCode);
    }
}
