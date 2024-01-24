package com.atguigu.rabbitmq.test01;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenyv
 * @description : 生产者
 * @since : 2023-12-13 22:18
 */
public class Producer {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("chenyv");
        factory.setPassword("wql19990322");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        Map<String, Object> arguments = new HashMap<>();
        // 设置队列优先级范围为0-10
        arguments.put("x-max-priority", 10);
        channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);


        for (int i = 1; i <11 ; i++) {
            String message = "info" + i;
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .priority(i)
                    .build();
            channel.basicPublish("", QUEUE_NAME, properties, message.getBytes());

        }
    }
}
