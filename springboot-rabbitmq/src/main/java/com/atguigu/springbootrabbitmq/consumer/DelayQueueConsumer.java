package com.atguigu.springbootrabbitmq.consumer;

import com.atguigu.springbootrabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author : chenyv
 * @since :  2024-01-22 15:54:54
 **/
@Slf4j
@Component
public class DelayQueueConsumer {
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayQueue(Message message) {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("当前时间：{}，延迟队列收到消息：{}", new Date(), msg);
    }
}
