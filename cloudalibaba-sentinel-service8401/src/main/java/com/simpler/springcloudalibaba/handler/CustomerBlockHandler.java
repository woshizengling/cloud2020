package com.simpler.springcloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.simpler.springcloud.entities.CommonResult;
import com.simpler.springcloud.entities.Payment;
import org.springframework.context.annotation.Configuration;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/15 16:09
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException blockException) {
        return new CommonResult(444, "按客户自定义,global handlerException-----1");
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(444, "按客户自定义,global handlerException-------2");
    }
}
