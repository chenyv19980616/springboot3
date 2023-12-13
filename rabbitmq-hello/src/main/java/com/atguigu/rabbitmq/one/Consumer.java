package com.atguigu.rabbitmq.one;

import com.rabbitmq.client.*;

/**
 * @author : chenyv
 * @description : 消费者
 * @since : 2023-12-13 22:52
 */
public class Consumer {
    public static final String QUENE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("chenyv");
        factory.setPassword("wql19990322");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.err.println(new String(message.getBody()));
        };

        CancelCallback cancelCallback = consumerTag->{
            System.err.println("消息中断消费！");
        };

        //消费消息
        channel.basicConsume(QUENE_NAME,true,deliverCallback,cancelCallback);
    }
}
