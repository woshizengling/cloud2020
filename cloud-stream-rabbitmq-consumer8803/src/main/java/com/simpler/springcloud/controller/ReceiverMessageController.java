package com.simpler.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/11 12:34
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiverMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者2号，－－－－－－－－－－＞接受到的消息: " + message.getPayload() + "\t port: " + serverPort);
    }

}
