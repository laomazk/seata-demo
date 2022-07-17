package com.magic.business.feign;

import com.magic.common.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laoma
 * @create 2022-07-17 0:19
 */
@FeignClient("storage")
public interface StorageFeign {
    @PostMapping("/deduct")
    RespBean deduct(@RequestParam("productId") String productId, @RequestParam("count") Integer count);
}
