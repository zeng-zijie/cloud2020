package com.zichun.speingcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/30 19:29
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService --- paymentInfo_OK --- " + id;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService --- paymentInfo_TimeOut --- " + id;
    }
}
