package com.magic.order.service;

import com.magic.common.RespBean;
import com.magic.order.feign.AccountFeign;
import com.magic.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    AccountFeign accountFeign;

    @Autowired
    OrderMapper orderMapper;

    public boolean createOrder(String account, String productId, Integer count) {
        //先去扣款，假设每个产品100块钱
        RespBean respBean = accountFeign.deduct(account, count * 100.0);
        int i = orderMapper.addOrder(account, productId, count, count * 100.0);
        return i == 1 && respBean.getStatus() == 200;
    }
}