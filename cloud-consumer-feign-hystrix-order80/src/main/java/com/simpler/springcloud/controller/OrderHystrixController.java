package com.simpler.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.simpler.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/08 18:04
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
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
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {

        int i = 10 / 0;

        String result = paymentHystrixService.paymentInfo_timeout(id);

        return result;
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池：　" + Thread.currentThread().getName() + " 系统繁忙，请稍后再试,id: " + id + "\t~~~Ｏ（∩＿∩）Ｏ哈哈～";
    }

    /**
     * 全局fallback方法
     * @param id
     * @return: java.lang.String
     * @author: simpler
     * @date: 2020/12/8 下午10:21
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍等．．．．";
    }

}
