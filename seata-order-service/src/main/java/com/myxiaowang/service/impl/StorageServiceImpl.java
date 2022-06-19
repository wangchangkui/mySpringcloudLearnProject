package com.myxiaowang.service.impl;

import com.myxiaowang.service.StorageService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:28:00
 */
@Slf4j
public class StorageServiceImpl implements StorageService {


    @Override
    public String deduct(Long productId, Integer count) {
        log.error("减库存异常");
        return "fail";
    }
}
