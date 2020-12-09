package com.simpler.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/09 22:35
 */
@SpringBootApplication
@EnableConfigServer
public class MainAppConfigCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class, args);
    }
}
