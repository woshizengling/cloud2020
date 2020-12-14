package com.simpler.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/14 14:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain8300 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain8300.class, args);
    }
}
