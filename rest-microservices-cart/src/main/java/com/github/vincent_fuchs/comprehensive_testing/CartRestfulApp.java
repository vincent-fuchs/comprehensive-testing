package com.github.vincent_fuchs.comprehensive_testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CartRestfulApp {

    public static void main(String[] args) {
        SpringApplication.run(CartRestfulApp.class, args);
    }
}
