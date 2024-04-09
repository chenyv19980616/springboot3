package com.atguigu.threadsafe02;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:53
 */
public class ThreadSafeDemo02 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
