package com.atguigu.thread02;

/**
 * @author : chenyv
 * @since : 2024-04-07 23:13
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "：hello world !");
        }
    }
}
