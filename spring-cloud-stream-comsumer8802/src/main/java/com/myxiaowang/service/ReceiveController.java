package com.myxiaowang.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月22日 19:32:00
 * Sink.类似于消息的消费者
 * Source 类似于生产者
 *
 */

@Slf4j
@Component
@EnableBinding(Sink.class)
public class ReceiveController {


    @Value("${server.port}")
    private String port;

    /**
     * 监听的输入流
     * @param message 生产者的消息
     */
    @StreamListener(Sink.INPUT)
    public void getMessages(Message<String> message){
        String payload = message.getPayload();
        log.info("接收到消息："+payload);
        log.info("消费者1号端口："+port);
    }
}
