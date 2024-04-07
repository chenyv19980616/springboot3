package com.atguigu.thread01;

/**
 * @author : chenyv
 * @since : 2024-04-07 22:58
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("线程1");
        MyThread t2 = new MyThread();
        t2.setName("线程2");
        t1.start(); 
        t2.start();
    }
}
