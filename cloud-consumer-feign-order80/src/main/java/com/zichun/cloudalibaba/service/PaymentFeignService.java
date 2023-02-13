package com.zichun.cloudalibaba.service;

import com.zichun.cloudalibaba.entities.CommonResult;
import com.zichun.cloudalibaba.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/29 17:39
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


}
