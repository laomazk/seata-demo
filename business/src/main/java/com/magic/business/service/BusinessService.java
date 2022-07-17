package com.magic.business.service;

import com.magic.business.feign.OrderFeign;
import com.magic.business.feign.StorageFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author laoma
 * @create 2022-07-17 0:16
 */
@Service
public class BusinessService {

    @Autowired
    OrderFeign orderFeign;

    @Autowired
    StorageFeign storageFeign;

    @GlobalTransactional
    public void purchase(String account, String productId, Integer count) {
        orderFeign.createOrder(account, productId, count);
        storageFeign.deduct(productId, count);
    }
}
