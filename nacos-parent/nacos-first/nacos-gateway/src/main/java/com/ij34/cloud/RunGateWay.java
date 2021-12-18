package com.ij34.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class RunGateWay {


   public static void main(String[] args) {
	SpringApplication.run(RunGateWay.class, args);
}
}
