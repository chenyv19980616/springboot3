package com.atguigu.rabbitmq.test08;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenyv
 * @description : 消费者1
 * @since :  2024-01-09 14:21:12
 **/
public class Consumer02 {

    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        System.out.println("Consumer02 等待接收消息...");

        DeliverCallback deliverCallback = (consumerTag, message)->{
            System.out.println("Consumer02 接收到的消息为：" + new String(message.getBody(), StandardCharsets.UTF_8));
        };
        channel.basicConsume(DEAD_QUEUE, true, deliverCallback, consumerTag -> {});
    }

}
