package org.example.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CartRestfulApp {

    public static void main(String[] args) {
        SpringApplication.run(CartRestfulApp.class, args);
    }
}
