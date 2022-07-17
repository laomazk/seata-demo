package com.magic.account.service;

import com.magic.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author laoma
 * @create 2022-07-17 0:29
 */
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public boolean deductAccount(String account, Double money) {
        accountMapper.updateAccount(account, money);
        Double m = accountMapper.getMoneyByAccount(account);
        if (m >= 0) {
            return true;
        }
        throw new RuntimeException("账户余额不足");
    }
}
