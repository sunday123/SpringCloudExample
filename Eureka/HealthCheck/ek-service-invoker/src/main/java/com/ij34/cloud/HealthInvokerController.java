package com.ij34.cloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.appinfo.InstanceInfo;

@RestController
@Configuration
public class HealthInvokerController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
   
	/**
	 * 查询可用服务
	 */
	private List<ServiceInstance> getServiceInstances() {
		List<String> ids = discoveryClient.getServices();
		List<ServiceInstance> result = new ArrayList<ServiceInstance>();
		for (String id : ids) {
			List<ServiceInstance> ins = discoveryClient.getInstances(id);
			result.addAll(ins);
		}
		return result;
	}

	  
	     @RequestMapping(value="/router",method=RequestMethod.GET)
	 	public String getRouter(){
	 		// 查找服务列表
	 		List<ServiceInstance> list = getServiceInstances();
	 		// 输出服务信息及状态
	 		for (ServiceInstance service : list) {
	 			EurekaServiceInstance esi = (EurekaServiceInstance) service;
	 			InstanceInfo info = esi.getInstanceInfo();
	 			System.out.println(info.getAppName() + "---" + info.getInstanceId()+ "---" + info.getStatus());
	 		}
	 		return "";
	 	}  
	  
}
