package com.atguigu.threadmethod02;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:24
 */
public class MyThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}
