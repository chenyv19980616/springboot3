package com.atguigu.threadmethod02;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:23
 */
public class ThreadMethodDemo02 {
    public static void main(String[] args) {
        MyThread01 t1 = new MyThread01();
        MyThread02 t2 = new MyThread02();
        t1.setName("女神");
        t2.setName("备胎");
        // 设置守护线程
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
