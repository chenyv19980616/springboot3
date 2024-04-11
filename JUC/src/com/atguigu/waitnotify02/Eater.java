package com.atguigu.waitnotify02;

import java.util.concurrent.BlockingQueue;

/**
 * @author : chenyv
 * @since : 2024-04-11 21:16
 */
public class Eater extends Thread {

    BlockingQueue<String> queue;

    public Eater(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String food = queue.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
