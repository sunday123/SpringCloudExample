package com.ij34.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TitleInvokerController {
	@Autowired
	LoadBalancerClient loadBalancerClient;
    @Autowired
	TitleOpenFeignClient titleOpenFeignClient;


	    @GetMapping(value="/router/{num}")
	 	public Object getRouter(@PathVariable("num") Integer num ){
			 return  new RestTemplate().getForObject(loadBalancerClient.choose("nacos-provider").getUri() + "/title/" + num, Object.class);

	 	}

	@GetMapping(value="/router2/{num}")
	public Object getRouter2(@PathVariable("num") Integer num ){
		return  titleOpenFeignClient.getRouter2(num);
	}

}
