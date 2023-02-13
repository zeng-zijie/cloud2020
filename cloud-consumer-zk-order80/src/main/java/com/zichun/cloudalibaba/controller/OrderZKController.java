package com.zichun.cloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/20 13:51
 */

@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public  String paymentInfo(){
        log.info("invoke paymentInfo");
        String object = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return object;
    }


}
