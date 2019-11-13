package com.ij34.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EKServer {
        public static void main(String[] args) {
        	//选profiles启动服务
        	@SuppressWarnings("resource")
			Scanner scanner =new Scanner(System.in);
        	String profiles=scanner.nextLine();
        	
			new SpringApplicationBuilder(EKServer.class).profiles(profiles).run(args);
		}
}
