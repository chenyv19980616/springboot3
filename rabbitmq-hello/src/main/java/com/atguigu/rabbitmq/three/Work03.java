package com.atguigu.rabbitmq.three;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.atguigu.rabbitmq.utils.SleepUtils;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;

/**
 * @author : chenyv
 * @description : 消费者
 * @since : 2023-12-25 22:10
 */
public class Work03 {
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.err.println("C2等待接受消息，时间较长！");

        //设置为：1 不公平分发
        channel.basicQos(1);

        //消费
        channel.basicConsume(TASK_QUEUE_NAME, false,
                (consumerTag, message) -> {
                    //睡一秒
                    SleepUtils.sleep(10);
                    System.err.println("接收到的消息：" + new String(message.getBody(), StandardCharsets.UTF_8));
                    channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
                },
                consumerTag -> {
                    System.err.println(consumerTag + "消费者取消消费！");
                });
    }
}
