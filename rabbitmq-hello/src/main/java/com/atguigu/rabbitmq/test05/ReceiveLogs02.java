package com.atguigu.rabbitmq.test05;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

/**
 * @author : chenyv
 * @description : 接收方1
 * @since :  2024-01-05 10:13:07
 **/
public class ReceiveLogs02 {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        // 声明一个临时队列 队列名称是随机的 当消费者连接断开后 队列会自动删除
        String queueName = channel.queueDeclare().getQueue();
        // 交换机绑定到队列
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println("等待接收消息。。。");

        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println("ReceiveLogs02 接收到的消息为：" + new String(message.getBody(), StandardCharsets.UTF_8));
        };

        channel.basicConsume(queueName, true, deliverCallback, (consumerTag)->{});
    }
}
