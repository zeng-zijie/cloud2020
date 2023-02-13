package com.zichun.cloudalibaba.service.impl;

import com.zichun.cloudalibaba.dao.PaymentDao;
import com.zichun.cloudalibaba.entities.Payment;
import com.zichun.cloudalibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/18 18:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}


