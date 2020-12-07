package com.simpler.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author simpler
 * @program: springcloud_study
 * @description:
 * @create 2020/12/02 20:37
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced   //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
