package com.ij34.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class TitleInvokerController {

	@Value("${word}")
	private String word;

	  
	     @RequestMapping(value="/hello")
	 	public String getRouter(){
			 return  word;
	 	}

	  
}
