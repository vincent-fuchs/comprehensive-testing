package com.github.vincent_fuchs.comprehensive_testing;

import lombok.Data;

@Data
public class CountryRating {

    private String countryCode;

    private int rating;

    private boolean shouldOverride;

    public CountryRating(String countryCode, int rating, boolean shouldOverride){
        this.countryCode=countryCode;
        this.rating=rating;
        this.shouldOverride=shouldOverride;
    }
}

