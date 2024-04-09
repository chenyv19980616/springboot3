package com.atguigu.threadsafe01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenyv
 * @since : 2024-04-08 21:54
 */
public class MyThread extends Thread {

    static int tickets = 0;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tickets < 100) {
                    Thread.sleep(10);
                    tickets++;
                    System.out.println(getName() + "正在卖第" + tickets + "张票！");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
