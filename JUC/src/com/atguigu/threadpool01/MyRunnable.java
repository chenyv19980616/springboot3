package com.atguigu.threadpool01;

/**
 * @author : chenyv
 * @since : 2024-04-11 21:52
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // for (int i = 1; i <= 10; i++) {
        System.out.println(Thread.currentThread().getName());
        // }
    }
}
