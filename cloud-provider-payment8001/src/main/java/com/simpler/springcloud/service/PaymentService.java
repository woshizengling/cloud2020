package com.simpler.springcloud.service;

import com.simpler.springcloud.entities.Payment;

/**
 * @author simpler
 * @program: springcloud_study
 * @description:
 * @create 2020/12/02 19:58
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
