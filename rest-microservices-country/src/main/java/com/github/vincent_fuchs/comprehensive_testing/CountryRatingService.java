package com.github.vincent_fuchs.comprehensive_testing;

import java.util.HashMap;
import java.util.Map;

/**
 * An in-memory implementation of CountryRatingService with hardcoded values
 */
public class CountryRatingService {

    private static Map<String, CountryRating> countryRatings = new HashMap<>();

    static{
        countryRatings.put("FRA",new CountryRating(1,false));
        countryRatings.put("USA",new CountryRating(2,false));
        countryRatings.put("JAP",new CountryRating(4,false));
        countryRatings.put("IND",new CountryRating(3,true));
        countryRatings.put("GER",new CountryRating(1,true));
        countryRatings.put("ITA",new CountryRating(5,true));
    }

    public CountryRating getRating(String countryCode){

        return countryRatings.get(countryCode);

    }



}
