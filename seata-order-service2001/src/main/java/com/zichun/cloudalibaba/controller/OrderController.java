package com.zichun.cloudalibaba.controller;

import com.zichun.cloudalibaba.domain.CommonResult;
import com.zichun.cloudalibaba.domain.Order;
import com.zichun.cloudalibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 21:00
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }
}
