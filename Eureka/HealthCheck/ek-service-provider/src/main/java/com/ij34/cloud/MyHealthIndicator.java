package com.ij34.cloud;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
//健康指示

@Component
public class MyHealthIndicator implements HealthIndicator{

	@Override
	public Health health() {
	    if(HealthCheckController.canFlag){
	    	return new Health.Builder(Status.UP).build();
	    }else{
	    	return new Health.Builder(Status.DOWN).build();
	    }
	}

}
