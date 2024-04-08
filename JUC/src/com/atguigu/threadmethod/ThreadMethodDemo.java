package com.atguigu.threadmethod;

/**
 * @author : chenyv
 * @since : 2024-04-08 20:49
 */
public class ThreadMethodDemo {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread("飞机");
        MyThread t2 = new MyThread("坦克");

        t1.start();
        t2.start();
        // String name = Thread.currentThread().getName();
        // System.out.println("name = " + name);
        // System.out.println("++++++++++++++++++++");
        // Thread.sleep(5000);
        // System.out.println("====================");
    }
}
