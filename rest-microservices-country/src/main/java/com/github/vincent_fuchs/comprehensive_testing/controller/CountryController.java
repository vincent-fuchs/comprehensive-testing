package com.github.vincent_fuchs.comprehensive_testing.controller;

import com.github.vincent_fuchs.comprehensive_testing.model.CountryRating;
import com.github.vincent_fuchs.comprehensive_testing.service.CountryRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@RestController
@RequestMapping(value = "country")
public class CountryController {

    @Autowired
    private CountryRatingService countryRatingService;

    @RequestMapping(value = "/rating/{countryCode}", produces = APPLICATION_JSON_VALUE)
    public CountryRating getCountryRating(@PathVariable("countryCode") String countryCode) {
        return countryRatingService.getRating(countryCode);
    }
}
