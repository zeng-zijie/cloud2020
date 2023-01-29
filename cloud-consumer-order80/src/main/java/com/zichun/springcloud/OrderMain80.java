package com.zichun.springcloud;

import com.zichun.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/19 10:22
 */
@SpringBootApplication
@EnableEurekaClient
//Ribbon 使用其它负载均衡算法
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
