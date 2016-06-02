package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;

@Data
public class ComputedRisk {

    private String productName;

    private String riskBucket;

    private String comment;

    public ComputedRisk(String productName,String riskBucket){
        this.productName=productName;
        this.riskBucket=riskBucket;
    }
}
