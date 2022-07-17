package com.magic.business.controller;

import com.magic.business.service.BusinessService;
import com.magic.common.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoma
 * @create 2022-07-17 0:15
 */
@RestController
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @PostMapping("/order")
    public RespBean order(String account,String productId,Integer count){
        try {
            businessService.purchase(account,productId,count);
            return RespBean.ok("下单成功");
        } catch (Exception e){
            e.printStackTrace();
            return RespBean.error("下单失败",e.getMessage());
        }
    }
}
