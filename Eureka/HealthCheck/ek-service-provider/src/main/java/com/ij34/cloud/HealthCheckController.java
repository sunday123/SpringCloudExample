package com.ij34.cloud;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheckController {
	//判断是否访问
	static Boolean canFlag=false;
	
	
     @RequestMapping(value="/title/{canFlagID}",method=RequestMethod.GET)
	public String setCanFlag(@PathVariable("canFlagID") Boolean canFlag2){
    	 canFlag=canFlag2;
		return "当前是否正常访问:"+canFlag;
	}
}
