package com.simpler.springcloudalibaba.controller;

import com.simpler.springcloud.entities.CommonResult;
import com.simpler.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/15 16:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L,"123144343534322322323"));
        hashMap.put(2L, new Payment(2L,"1231442235343223dfdedf"));
        hashMap.put(3L, new Payment(3L,"12314434353432232iidfd"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql, serverPort: " + serverPort, payment);

        return result;
    }

}
