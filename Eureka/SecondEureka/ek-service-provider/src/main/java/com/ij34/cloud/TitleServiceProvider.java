package com.ij34.cloud;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TitleServiceProvider {

	public static void main(String[] args) {
    	//选端口启动服务
    	@SuppressWarnings("resource")
		Scanner scanner =new Scanner(System.in);
    	String profiles=scanner.nextLine();
    	
		new SpringApplicationBuilder(TitleServiceProvider.class).properties("server.port="+profiles).run(args);
	}
}
