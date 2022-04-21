package com.ij34.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

/**
 * Description TitleOpenFeignClient
 * Date 2021/12/18
 * Created by www.ij34.com
 */
@FeignClient(name = "nacos-provider",path = "/",fallbackFactory = DefaultFallbackProviderImpl.class)
public interface TitleOpenFeignClient {
    @GetMapping("/title/{id}")
    Object getRouter2(@PathVariable("id") Integer id );

    @GetMapping("/title/add/{id}")
    Response addRouter2(@PathVariable("id") Integer id );
}
