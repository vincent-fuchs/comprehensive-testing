package com.github.vincent_fuchs.comprehensive_testing.controller;

import com.github.vincent_fuchs.comprehensive_testing.service.CartService;
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
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(path = "/add/{productName}", method = GET, produces = APPLICATION_JSON_VALUE)
    public String getProductRisk(@PathVariable("productName") String productName) {
        return cartService.getProductRisk(productName);
    }
}
