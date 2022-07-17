package com.magic.account.controller;

import com.magic.account.service.AccountService;
import com.magic.common.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoma
 * @create 2022-07-17 0:31
 */
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/deductAccount")
    public RespBean deduct(String account, Double money) {
        if (accountService.deductAccount(account, money)) {
            return RespBean.ok("扣款成功");
        }
        return RespBean.error("扣款失败");
    }

    @GetMapping("/hello")
    public void hello(){
        System.out.println("hello");
    }
}
