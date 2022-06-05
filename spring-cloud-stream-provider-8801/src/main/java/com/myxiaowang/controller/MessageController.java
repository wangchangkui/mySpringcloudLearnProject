package com.myxiaowang.controller;

import com.myxiaowang.service.IMessagerProvider;
import com.myxiaowang.service.impl.IMessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月22日 18:48:00
 */
@RestController
public class MessageController {
    @Autowired
    private IMessagerProvider messageProvider;

    @GetMapping("/messages/{message}")
    public String sendMessage(@PathVariable String message){
        return messageProvider.sendMessage(message);
    }
}
