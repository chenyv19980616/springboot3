package com.atguigu.threadpool01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenyv
 * @since : 2024-04-11 21:49
 */
public class MyThreadPoolDemo01 {
    public static void main(String[] args) throws Exception {
        ExecutorService pool1 = Executors.newFixedThreadPool(3);
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        // pool1.shutdown();
    }
}
