package com.atguigu.threadmethod03;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:33
 */
public class ThreadMethodDemo03 {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        // MyThread t2 = new MyThread();
        t1.setName("飞机");
        // t2.setName("坦克");
        t1.start();
        // t2.start();
        t1.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("main" + i);
        }
    }
}
