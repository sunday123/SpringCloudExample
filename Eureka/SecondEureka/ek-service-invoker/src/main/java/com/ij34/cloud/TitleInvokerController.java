package com.ij34.cloud;

import java.util.Random;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class TitleInvokerController {
	final Random random = new Random();
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	  
	     @RequestMapping(value="/router",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 	public String getRouter(){
	 		return getRestTemplate().getForObject("http://ek-service-provider/title/5", String.class);
	 	}  
	  
}
