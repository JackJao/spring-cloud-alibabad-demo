package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//服务注册与发现
@SpringBootApplication
@EnableDiscoveryClient //开启服务注册与发现功能
public class UserServerApplication1010 {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication1010.class);
    }
}