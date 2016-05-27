package com.github.vincent_fuchs.comprehensive_testing;

import lombok.Data;

@Data
public class CountryRating {

    public CountryRating(int rating, boolean shouldOverride){
        setRating(rating);
        setShouldOverride(shouldOverride);
    }

    private int rating;

    private boolean shouldOverride;

}
