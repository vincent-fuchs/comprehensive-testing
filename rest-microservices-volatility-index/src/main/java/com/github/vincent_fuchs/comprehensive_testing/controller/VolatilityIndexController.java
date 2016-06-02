package com.github.vincent_fuchs.comprehensive_testing.controller;

import com.github.vincent_fuchs.comprehensive_testing.service.VolatilityIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@RestController
@RequestMapping(value = "volatilityIndex")
public class VolatilityIndexController {
    @Autowired
    private VolatilityIndexService productService;

    @RequestMapping(value = "/{productName}", method = GET, produces = APPLICATION_JSON_VALUE)
    public String getProductVolatilityIndex(@PathVariable("productName") String productName) {
        return productService.getProductVolatilityIndex(productName);
    }
}
