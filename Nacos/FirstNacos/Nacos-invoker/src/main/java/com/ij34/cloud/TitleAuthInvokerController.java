package com.ij34.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Description TitleAuthInvokerController
 * Date 2021/12/18
 * Created by www.ij34.com
 */
@RestController
@RequestMapping("/auth")
@Slf4j
public class TitleAuthInvokerController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    TitleOpenFeignClient titleOpenFeignClient;
    @Autowired
    private HttpServletRequest request;


    @GetMapping(value="/router/{num}")
    public Object getRouter(@PathVariable("num") Integer num ){
        log.info("token:"+request.getHeader("token"));
        return  new RestTemplate().getForObject(loadBalancerClient.choose("nacos-provider").getUri() + "/title/" + num, Object.class);

    }

    @GetMapping(value="/router2/{num}")
    public Object getRouter2(@PathVariable("num") Integer num ){
        return  titleOpenFeignClient.getRouter2(num);
    }

}
