package org.example.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Anand
 *
 * @author <a href="mailto:anand.manissery@gmail.com">Anand Manissery</a>
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApp {

    public static void main(String[] args) {
        SpringApplication.run(RegistryApp.class, args);
    }
}
