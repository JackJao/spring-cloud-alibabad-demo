package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//服务注册与发现
@SpringBootApplication
@EnableDiscoveryClient //开启服务注册与发现功能
@EnableFeignClients //开启Feign
public class OrderServerApplication1020 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication1020.class);
    }
}