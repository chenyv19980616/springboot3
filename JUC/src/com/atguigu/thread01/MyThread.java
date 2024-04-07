package com.atguigu.thread01;

/**
 * @author : chenyv
 * @since : 2024-04-07 22:59
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "：hello world !");
        }
    }
}
