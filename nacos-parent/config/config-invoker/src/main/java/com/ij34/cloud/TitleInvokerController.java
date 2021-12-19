package com.ij34.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class TitleInvokerController {

	@Autowired
	private ConfigurableApplicationContext applicationContext;
	  
	     @GetMapping(value="/hello")
	 	public String getRouter(){
			 System.out.println(applicationContext.getEnvironment().toString());
			 return  applicationContext.getEnvironment().getProperty("word");
	 	}

	  
}
