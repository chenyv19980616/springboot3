package com.atguigu.thread02;

/**
 * @author : chenyv
 * @since : 2024-04-07 23:15
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        MyRunnable myRun = new MyRunnable();

        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}
