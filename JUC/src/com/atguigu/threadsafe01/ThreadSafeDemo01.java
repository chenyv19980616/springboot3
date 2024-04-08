package com.atguigu.threadsafe01;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:53
 */
public class ThreadSafeDemo01 {
    /*
    三个窗口卖100张票
     */
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
