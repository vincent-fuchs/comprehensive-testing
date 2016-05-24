package com.github.vincent_fuchs.comprehensive_testing.convenient_classes_for_test;

import com.github.vincent_fuchs.comprehensive_testing.CountryRating;
import com.github.vincent_fuchs.comprehensive_testing.CountryRatingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryRatingServiceTestImpl implements CountryRatingService {

    private Map<String, CountryRating> countryRatings = new HashMap<>();

    public CountryRatingServiceTestImpl(List<CountryRating> ratings) {
        for (CountryRating rating : ratings) {
            countryRatings.put(rating.getCountryCode(), rating);
        }
    }

    @Override
    public CountryRating getRating(String countryCode) {
        return countryRatings.get(countryCode);
    }
}
