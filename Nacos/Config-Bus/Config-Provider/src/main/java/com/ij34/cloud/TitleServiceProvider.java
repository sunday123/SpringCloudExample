package com.ij34.cloud;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class TitleServiceProvider {

	public static void main(String[] args) {

		new SpringApplicationBuilder(TitleServiceProvider.class).run(args);

	}




}
