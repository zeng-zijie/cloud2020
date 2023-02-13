package com.zichun.cloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/20 15:55
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final  String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public  String paymentInfo(){
        log.info("invoke paymentInfo consul");
        String object = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return object;
    }


}
