package com.simpler.springcloudalibaba.service;

import com.simpler.springcloud.entities.CommonResult;
import com.simpler.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/15 21:01
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，－－－－－－PaymentFallbackService", new Payment(id, "error"));
    }
}
