package com.atguigu.threadsafe01;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:54
 */
public class MyThread extends Thread {

    static int tickets = 0;

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized (MyThread.class) {
                if (tickets < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tickets++;
                    System.out.println(getName() + "正在卖第" + tickets + "张票！");
                } else {
                    break;
                }
            }
        }
    }
}
