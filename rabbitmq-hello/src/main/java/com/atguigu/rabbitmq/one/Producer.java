package com.atguigu.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author : chenyv
 * @description : 生产者
 * @since : 2023-12-13 22:18
 */
public class Producer {
    public static final String QUENE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("chenyv");
        factory.setPassword("wql19990322");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUENE_NAME, false, false, false, null);

        //发消息
        String message = "hello world !";
        channel.basicPublish("", QUENE_NAME, null, message.getBytes());
        System.err.println("发送完毕！");
    }
}
