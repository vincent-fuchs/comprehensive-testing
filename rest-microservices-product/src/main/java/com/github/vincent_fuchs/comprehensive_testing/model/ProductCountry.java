package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Data
public class ProductCountry {
    private String productName;
    private String countryCode;

    public ProductCountry() {
        super();
    }

    public ProductCountry(String productName, String countryCode) {
        setProductName(productName);
        setCountryCode(countryCode);
    }
}
