package com.zichun.springcloud.controller;

import com.zichun.springcloud.entities.CommonResult;
import com.zichun.springcloud.entities.Payment;
import com.zichun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**** 插入结果: " + result + " ****");
        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功!", result);
        } else {
            return new CommonResult<Integer>(444, "插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**** 查询结果: " + payment + " ****");
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功!", payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应记录,查询ID: " + id);
        }
    }


}
