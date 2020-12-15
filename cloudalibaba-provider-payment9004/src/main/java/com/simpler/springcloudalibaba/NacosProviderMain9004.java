package com.simpler.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/15 16:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9004.class, args);
    }
}
