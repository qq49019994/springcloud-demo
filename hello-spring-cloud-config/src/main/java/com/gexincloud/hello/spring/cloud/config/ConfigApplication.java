package com.gexincloud.hello.spring.cloud.config;

// - - 开始的时候忘记忽略.idea目录了 导致现在idea自动提交了 我删掉或者忽略还不能合并到主干
//经过一番折腾 终于提交了

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}