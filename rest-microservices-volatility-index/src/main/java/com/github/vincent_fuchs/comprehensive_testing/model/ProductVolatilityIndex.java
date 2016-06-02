package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Data
public class ProductVolatilityIndex {
    private String productName;
    private String volatilityIndex;

    public ProductVolatilityIndex(String productName, String volatilityIndex) {
        setProductName(productName);
        setVolatilityIndex(volatilityIndex);
    }
}
