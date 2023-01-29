package com.zichun.springcloud.controller;

import com.zichun.springcloud.entities.CommonResult;
import com.zichun.springcloud.entities.Payment;
import com.zichun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/18 18:40
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**** 插入结果: " + result + " ****");
        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功! serverPort: " + serverPort, result);
        } else {
            return new CommonResult<Integer>(444, "插入数据库失败! serverPort: " + serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**** 查询结果: " + payment + " ****");
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功! serverPort: " + serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应记录,查询ID: " + id + " serverPort: " + serverPort);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****element: "+ element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() +"\t"
                    + instance.getHost()+"\t"
                    + instance.getPort()+"\t"
                    + instance.getUri()
            );
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
