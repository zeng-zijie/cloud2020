package com.zichun.cloudalibaba.service;

import com.zichun.cloudalibaba.entities.CommonResult;
import com.zichun.cloudalibaba.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 15:14
 */
@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
