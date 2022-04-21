package com.ij34.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
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

	@GetMapping(value="/router2/add/{num}")
	@ResponseBody
	public Response addRouter2(@PathVariable("num") Integer num ){
		log.info("req"+num);
		Response response= titleOpenFeignClient.addRouter2(num);
		log.info(response.toString());
		return response;
	}

}
