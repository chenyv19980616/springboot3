package com.atguigu.waitnotify02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : chenyv
 * @since : 2024-04-11 21:15
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 阻塞队列
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Cooker cooker = new Cooker(queue);
        Eater eater = new Eater(queue);

        cooker.start();
        eater.start();
    }
}
