package com.magic.order.controller;

import com.magic.common.RespBean;
import com.magic.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public RespBean createOrder(@RequestParam("account") String account, @RequestParam("productId") String productId, @RequestParam("count") Integer count) {
        if (orderService.createOrder(account, productId, count)) {
            return RespBean.ok("下单成功");
        }
        return RespBean.error("下单失败");
    }
}