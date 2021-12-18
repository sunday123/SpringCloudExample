package com.ij34.cloud;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Description TitleAuthInvokerController
 * Date 2021/12/18
 * Created by www.ij34.com
 */
@RestController
@RequestMapping("/auth")
public class TitleAuthInvokerController {
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
