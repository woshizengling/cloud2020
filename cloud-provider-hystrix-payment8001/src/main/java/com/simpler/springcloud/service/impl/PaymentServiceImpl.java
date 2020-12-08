package com.simpler.springcloud.service.impl;

import com.simpler.springcloud.dao.PaymentDao;
import com.simpler.springcloud.entities.Payment;
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

    @Override
    public String paymentInfo_timeout(Integer id) {

        int number = 3;

        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：　" + Thread.currentThread().getName() + " paymentInfo_timeout,id: " + id + "\t~~~耗时" + number + "秒钟";
    }
}
