package com.zichun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/29 17:34
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class, args);
    }
}
