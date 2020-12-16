package com.simpler.springcloud.controller;

import com.simpler.springcloud.domain.Order;
import com.simpler.springcloud.entities.CommonResult;
import com.simpler.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/16 22:59
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderServiceImpl;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @GetMapping("create")
    public CommonResult create(Order order){
        orderServiceImpl.create(order);
        return new CommonResult(200, "Create order success");
    }

    /**
     * 修改订单状态
     * @param userId
     * @param money
     * @param status
     * @return
     */
    @RequestMapping("update")
    public String update(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money, @RequestParam("status") Integer status){
        orderServiceImpl.update(userId,money,status);
        return "订单状态修改成功";
    }
}
