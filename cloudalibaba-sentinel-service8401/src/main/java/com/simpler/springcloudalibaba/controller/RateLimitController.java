package com.simpler.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.simpler.springcloud.entities.CommonResult;
import com.simpler.springcloud.entities.Payment;
import com.simpler.springcloudalibaba.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/15 15:52
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2L, "111"));
    }

    public CommonResult handleException(BlockException blockException) {
        return new CommonResult(4444, blockException.getClass().getCanonicalName() + "\t服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL限流测试OK", new Payment(2L, "111"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流测试OK", new Payment(2L, "111"));
    }

}
