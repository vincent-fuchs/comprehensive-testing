package com.github.vincent_fuchs.comprehensive_testing.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Service
@FeignClient(name = "volatility-index-service")
public interface VolatilityIndexService {

    @RequestMapping(value = "/volatilityIndex/{productName}", method = GET, produces = APPLICATION_JSON_VALUE)
    String getProductVolatilityIndex(@PathVariable("productName") String productName);
}
