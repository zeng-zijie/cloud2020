package com.zichun.cloudalibaba.service;

import com.zichun.cloudalibaba.entities.Payment;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/18 18:34
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
