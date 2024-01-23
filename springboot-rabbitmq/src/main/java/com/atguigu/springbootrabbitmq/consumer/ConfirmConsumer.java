package com.atguigu.springbootrabbitmq.consumer;

import com.atguigu.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author : chenyv
 * @since :  2024-01-23 14:31:29
 **/
@Slf4j
@Component
public class ConfirmConsumer {
    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveConfirmMessage(Message message) {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("队列：confirm.queue接收到消息：{}", msg);
    }
}
