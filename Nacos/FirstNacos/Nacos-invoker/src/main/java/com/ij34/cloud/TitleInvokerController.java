package com.ij34.cloud;

import org.springframework.beans.factory.annotation.Autowired;
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

	private final RestTemplate restTemplate;

	@Autowired
	public TitleInvokerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	  
	     @RequestMapping(value="/router",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 	public String getRouter(){
	 		return restTemplate.getForObject("http://nacos-provider/title/666", String.class);
	 	}  
	  
}
