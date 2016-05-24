package com.github.vincent_fuchs.comprehensive_testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductRestfulApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductRestfulApp.class, args);
    }
}
