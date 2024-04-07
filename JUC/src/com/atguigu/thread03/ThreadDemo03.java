package com.atguigu.thread03;

import java.util.concurrent.FutureTask;

/**
 * @author : chenyv
 * @since : 2024-04-07 23:42
 */
public class ThreadDemo03 {
    public static void main(String[] args) throws Exception {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(mc);
        Thread t1 = new Thread(futureTask);
        t1.start();
        System.out.println(futureTask.get());

    }
}
