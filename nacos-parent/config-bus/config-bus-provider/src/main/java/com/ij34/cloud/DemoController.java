package com.ij34.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @Autowired
	ApplicationEventPublisher applicationEventPublisher;

    @Autowired
	ServiceMatcher busServiceMatcher;

    @GetMapping("/reg")
    public String register(String username) {
        // ... 执行注册逻辑
        System.out.println("[register][执行用户({" + username + "}) 的注册逻辑]");

        // ... 发布
        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(this, busServiceMatcher.getBusId(),
                null, username);
        applicationEventPublisher.publishEvent(userRegisterEvent);
        return userRegisterEvent.toString();
    }


}
