package com.atguigu.threadmethod03;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:33
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "@" + i);
            Thread.yield();
        }
    }
}
