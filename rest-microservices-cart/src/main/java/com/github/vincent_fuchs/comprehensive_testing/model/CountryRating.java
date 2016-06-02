package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;


@Data
public class CountryRating {
    private int rating;

    private boolean shouldOverride;

    private String countryCode;

    public CountryRating() {
        super();
    }

    public CountryRating(String countryCode,int rating, boolean shouldOverride) {
        this.countryCode=countryCode;
        this.rating=rating;
        this.shouldOverride=shouldOverride;
    }
}

