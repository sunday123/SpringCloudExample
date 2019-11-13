package com.ij34.cloud;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TitleServiceProvider {

	public static void main(String[] args) {
		new SpringApplicationBuilder(TitleServiceProvider.class).run(args);
	}
}
