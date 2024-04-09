package com.atguigu.waitnotify;

/**
 * @author : chenyv
 * @since : 2024-04-09 23:38
 */
public class Eater extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.foodFlag == 0) {
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("吃饭中，还能再吃" + Desk.count + "碗");
                    Desk.lock.notifyAll();
                    Desk.count--;
                    Desk.foodFlag = 0;
                }
            }
        }
    }
}
