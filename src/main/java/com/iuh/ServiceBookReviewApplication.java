package com.iuh;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBookReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBookReviewApplication.class, args);
    }

}
