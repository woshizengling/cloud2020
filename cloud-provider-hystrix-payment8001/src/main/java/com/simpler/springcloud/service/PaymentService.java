package com.simpler.springcloud.service;

/**
 * @author simpler
 * @program: springcloud_study
 * @description:
 * @create 2020/12/02 19:58
 */
public interface PaymentService {

    String paymentInfo_ok(Integer id);

    String paymentInfo_timeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
