package com.zichun.springcloud.controller;

import com.zichun.springcloud.entities.CommonResult;
import com.zichun.springcloud.entities.Payment;
import com.zichun.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/19 11:20
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Integer> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        return restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class).getBody();
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {

        //获取 eureka(注册中心) 上的服务提供者列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null ||  instances.size() <= 0 ){
            return null;
        }

        //根据负载均衡算法选择一个提供者
        ServiceInstance serviceInstance = loadBalancer.instances(instances);

        URI uri = serviceInstance.getUri();
        System.out.println("uri :" + uri);
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }


    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://192.168.1.101:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}
