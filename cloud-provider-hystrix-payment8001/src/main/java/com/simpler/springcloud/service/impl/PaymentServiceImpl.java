package com.simpler.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.simpler.springcloud.dao.PaymentDao;

import com.simpler.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author simpler
 * @program: springcloud_study
 * @description:
 * @create 2020/12/02 19:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池：　" + Thread.currentThread().getName() + " paymentInfo_ok,id: " + id + "\t~~~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeout(Integer id) {

        int number = 2;

//        int i = 10 / 0;

        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：　" + Thread.currentThread().getName() + " paymentInfo_timeout,id: " + id + "\t~~~耗时" + number + "秒钟";
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池：　" + Thread.currentThread().getName() + " 系统繁忙，请稍后再试,id: " + id + "\t~~~Ｏ（∩＿∩）Ｏ哈哈～";
    }
}
