package com.github.vincent_fuchs.comprehensive_testing;

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
