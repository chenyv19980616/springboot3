package com.atguigu.threadmethod01;

/**
 * @author : chenyv
 * @since : 2024-04-08 20:51
 */
public class MyThread extends Thread{
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "@" + i);
        }
    }
}
