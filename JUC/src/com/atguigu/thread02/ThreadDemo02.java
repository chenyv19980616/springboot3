package com.atguigu.thread02;

/**
 * @author : chenyv
 * @since : 2024-04-07 23:15
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        MyRunnable myRun = new MyRunnable();

        Thread thread = new Thread(myRun);

        thread.start();
    }
}
