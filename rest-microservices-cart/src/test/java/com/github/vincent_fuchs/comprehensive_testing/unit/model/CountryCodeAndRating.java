package com.github.vincent_fuchs.comprehensive_testing.unit.model;

import com.github.vincent_fuchs.comprehensive_testing.model.CountryRating;
import lombok.Data;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Data
public class CountryCodeAndRating extends CountryRating {

    private String countryCode;
}
