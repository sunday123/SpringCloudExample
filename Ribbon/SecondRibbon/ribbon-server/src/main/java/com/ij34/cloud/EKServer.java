package com.ij34.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EKServer {
        public static void main(String[] args) {
			new SpringApplicationBuilder(EKServer.class).run(args);
		}
}
