package com.gexincloud.hello.spring.cloud.web.admin.feign.service.fallack;

import com.gexincloud.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

//当请求出现错误的时候 级response code不等于200时 则熔断请求 并执行熔断内的方法
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
}