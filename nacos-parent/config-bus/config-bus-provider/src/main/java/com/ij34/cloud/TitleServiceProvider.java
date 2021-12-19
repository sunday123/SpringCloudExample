package com.ij34.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TitleServiceProvider {

    public static void main(String[] args) {

        SpringApplication.run(TitleServiceProvider.class, args);

    }

}
