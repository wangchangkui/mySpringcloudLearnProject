package com.myxiaowang.controller;

import com.myxiaowang.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:29:00
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public String deduct(@RequestParam("productId") Long productId,@RequestParam("count") Integer count){
        return storageService.deduct(productId, count);
    }
}
