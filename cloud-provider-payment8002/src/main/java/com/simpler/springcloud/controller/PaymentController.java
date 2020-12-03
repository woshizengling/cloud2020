package com.simpler.springcloud.controller;

import com.simpler.springcloud.entities.CommonResult;
import com.simpler.springcloud.entities.Payment;
import com.simpler.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author simpler
 * @program: springcloud_study
 * @description:
 * @create 2020/12/02 20:00
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "失败了");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);

        log.info("****插入结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录");
        }

    }

}
