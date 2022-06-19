package com.myxiaowang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 21:37:00
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/decrease")
    String deduct(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
