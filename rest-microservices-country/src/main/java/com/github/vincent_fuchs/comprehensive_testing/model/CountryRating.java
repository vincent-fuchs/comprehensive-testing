package com.github.vincent_fuchs.comprehensive_testing.model;

import lombok.Data;

@Data
public class CountryRating {

    private int rating;

    private boolean shouldOverride;

    public CountryRating(int rating, boolean shouldOverride) {
        setRating(rating);
        setShouldOverride(shouldOverride);
    }
}
