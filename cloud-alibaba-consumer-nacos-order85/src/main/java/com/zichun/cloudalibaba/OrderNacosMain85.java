package com.zichun.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 13:52
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosMain85 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain85.class, args);
    }
}
