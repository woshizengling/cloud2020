package com.simpler.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/08 22:30
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_timeout";
    }
}
