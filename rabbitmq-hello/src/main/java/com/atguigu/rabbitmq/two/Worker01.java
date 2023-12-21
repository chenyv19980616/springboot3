package com.atguigu.rabbitmq.two;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

/**
 * @author : chenyv
 * @description : 工作线程1
 * @since : 2023-12-21 22:17
 */
public class Worker01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.err.println("C2 waiting...");
        channel.basicConsume(QUEUE_NAME, true,
                (consumerTag, message) -> {
                    System.err.println("接收到的消息：" + new String(message.getBody()));
                },
                consumerTag -> {
                    System.err.println(consumerTag+"消费者取消消息！");
                });

    }
}
