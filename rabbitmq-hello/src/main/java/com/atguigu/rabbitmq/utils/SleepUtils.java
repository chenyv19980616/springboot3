package com.atguigu.rabbitmq.utils;

/**
 * @author : chenyv
 * @description : 睡觉工具类
 * @since : 2023-12-25 22:17
 */
public class SleepUtils {
    /**
     * 睡觉second秒
     * @param second
     */
    public static void sleep(int second) {
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
