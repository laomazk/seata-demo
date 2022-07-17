package com.magic.order.feign;

import com.magic.common.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account")
public interface AccountFeign {
    @PostMapping("/deductAccount")
    RespBean deduct(@RequestParam("account") String account, @RequestParam("money") Double money);
}