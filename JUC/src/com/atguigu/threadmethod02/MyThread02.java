package com.atguigu.threadmethod02;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:25
 */
public class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}
