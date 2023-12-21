package com.atguigu.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * @author : chenyv
 * @description : rabbitmq工具类
 * @since : 2023-12-21 22:11
 */
public class RabbitMqUtils {
    public static Channel getChannel() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("chenyv");
        factory.setPassword("wql19990322");
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }
}
