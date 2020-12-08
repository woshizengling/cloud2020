package com.simpler.springcloud.controller;

import com.simpler.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/08 18:04
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {

        String result = paymentHystrixService.paymentInfo_ok(id);

        log.info("********result: " + result);

        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {

        String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info("********result: " + result);

        return result;
    }

}
