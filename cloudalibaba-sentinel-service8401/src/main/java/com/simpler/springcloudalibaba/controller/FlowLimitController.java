package com.simpler.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/14 23:10
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {

//        TimeUnit.MILLISECONDS.sleep(800);

        return "__________testA";
    }

    @GetMapping("/testB")
    public String testB() {

        log.info(Thread.currentThread().getName() + "\t___testB");

        return "__________testB";
    }

    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        log.info("testD 测试异常比例");
        int age = 10 / 0;
        return "__________testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
//        int age = 10 / 0;
        return "_________testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {

//        int a = 10 / 0;

        return "___________testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException) {
        return "____________deal_testHotKey";//sentinel系统默认的提示： Blocked by Sentinel (flow limiting)
    }

}
