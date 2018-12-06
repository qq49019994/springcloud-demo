package com.gexincloud.hello.spring.cloud.web.admin.feign.service;

import com.gexincloud.hello.spring.cloud.web.admin.feign.service.fallack.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//调用提供者的接口
@FeignClient(value = "hello-spring-cloud-service-admin",fallback = AdminServiceHystrix.class)
public interface AdminService {

    //如果请求是get，那么必须要使用@RequestParam(value = "xxx")显示注解，否则传参过程中feign会以body的形式将参数传递
    //使提供者认为发了一个post请求 导致405错误
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);
}
