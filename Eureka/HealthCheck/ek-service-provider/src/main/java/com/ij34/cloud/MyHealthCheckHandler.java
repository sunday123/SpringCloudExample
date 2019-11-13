package com.ij34.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

//健康检测处理器
@Component
public class MyHealthCheckHandler implements HealthCheckHandler{
	@Autowired
	MyHealthIndicator indicator;
	@Override
	public InstanceStatus getStatus(InstanceStatus status) {
		if((Status.UP).equals(indicator.health().getStatus())){
			System.out.println("enjoy yourself");
			return InstanceStatus.UP;
		}else{
			System.out.println("don't connect");
			return InstanceStatus.DOWN;
		}
	}

}
