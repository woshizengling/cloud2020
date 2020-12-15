package com.simpler.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/15 16:36
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderConsumerMain8400 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain8400.class, args);
    }
}
