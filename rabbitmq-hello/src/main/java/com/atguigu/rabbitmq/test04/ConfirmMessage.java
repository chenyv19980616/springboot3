package com.atguigu.rabbitmq.test04;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author : chenyv
 * @description : 发布确认
 * @since : 2024-01-03 22:58
 * 1 单个确认
 * 2 批量确认
 * 3 异步确认
 */
public class ConfirmMessage {

    /**
     * 消息数量
     */
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws Exception {
        confirmAsync();
    }

    /**
     * 单个确认
     * 单个确认，用时：243
     */
    public static void confirmAlone() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        String queueName = UUID.randomUUID().toString();
        //声明队列
        channel.queueDeclare(queueName, true, false, false, null);
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("",queueName,null, message.getBytes());
            channel.waitForConfirms();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("单个确认，用时：" + (endTime - beginTime));
    }

    /**
     * 批量确认
     * 批量确认，用时：35
     */
    public static void confirmBatch() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        String queueName = UUID.randomUUID().toString();
        //声明队列
        channel.queueDeclare(queueName, true, false, false, null);
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("",queueName,null, message.getBytes());
            //批量确认
            if (i % 100 == 0) {
                channel.waitForConfirms();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("批量确认，用时：" + (endTime - beginTime));
    }

    /**
     * 异步确认
     * 异步确认，用时：19
     */
    public static void confirmAsync() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        String queueName = UUID.randomUUID().toString();
        //声明队列
        channel.queueDeclare(queueName, true, false, false, null);

        /*
        声明一个线程安全有序的hash表：outstandingConfirms
        1。 轻松将序号与消息关联
        2。 轻松删除消息
        3。 支持高并发（多线程）
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirmMap = new ConcurrentSkipListMap<>();

        //准备消息监听器
        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            //删除已经确认的消息
            ConcurrentNavigableMap<Long, String> confirmedMap = outstandingConfirmMap.headMap(deliveryTag);
            confirmedMap.clear();
        };

        ConfirmCallback nackCallback = (deliveryTag, multiple) -> {
            String s = outstandingConfirmMap.get(deliveryTag);
            System.out.println("未确认消息:" + deliveryTag + ":" + s);
        };

        //增加一个消息确认监听器
        channel.addConfirmListener(ackCallback, nackCallback);

        //开始时间
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("",queueName,null, message.getBytes());
            //将需要发送的消息放入hash表中
            outstandingConfirmMap.put(channel.getNextPublishSeqNo(), message);
        }
        //结束时间
        long endTime = System.currentTimeMillis();

        System.out.println("异步确认，用时：" + (endTime - beginTime));
    }

}
