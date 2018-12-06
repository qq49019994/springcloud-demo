package com.gexincloud.hello.spring.cloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    //我们已经把他注册好了 现在要提供第一个服务
    //把application.yml的port拿过来用 一会测试集群效果
    //妈的写错地方了 写到eureka项目了
    //下面搭建集群
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message) {
        return String.format("Hi，your message is : %s i am from port : %s", message, port);
    }
}
