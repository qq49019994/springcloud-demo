package com.gexincloud.hello.spring.cloud.web.admin.feign.controller;

import com.gexincloud.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    //出現了熔斷 看一下具體錯誤
    //发现是连接不上的问题
    //看看注册中心
    //初步发现是adminService注入失败
    //经过调试发现我们少写了一个注解 或者说是搞错了一个注解
    //现在我们再还原熔断
    //刚刚网页效果也看到了请求成功 并且提供者的端口在变，说明是负载均衡生效了
    //http://127.0.0.1:8765/hystrix 进入后请求发现这段时间内服务器请求数量的变化
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }
}