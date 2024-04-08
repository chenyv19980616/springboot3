package com.atguigu.threadmethod01;

/**
 * @author : chenyv
 * @since : 2024-04-08 20:49
 */
public class ThreadMethodDemo01 {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread("飞机");
        MyThread t2 = new MyThread("坦克");

        t1.start();
        t2.start();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        // String name = Thread.currentThread().getName();
        // System.out.println("name = " + name);
        // System.out.println("++++++++++++++++++++");
        // Thread.sleep(5000);
        // System.out.println("====================");
    }
}
