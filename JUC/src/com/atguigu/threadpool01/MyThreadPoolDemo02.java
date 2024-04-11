package com.atguigu.threadpool01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenyv
 * @since : 2024-04-11 22:25
 */
public class MyThreadPoolDemo02 {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                3,
                6,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 提交任务
        threadPool.submit(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("chenyu" + i);
            }
        });
        // 关闭线程池
        threadPool.shutdown();
    }
}
