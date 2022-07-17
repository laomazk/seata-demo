package com.magic.storage.controller;

import com.magic.common.RespBean;
import com.magic.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    @PostMapping("/deduct")
    public RespBean deduct(String productId, Integer count) {
        if (storageService.deduct(productId, count)) {
            return RespBean.ok("扣库存成功");
        }
        return RespBean.error("扣库存失败");
    }
}