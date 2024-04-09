package com.atguigu.threadsafe02;

public class MyRunnable implements Runnable {

    int tickets = 0;

    @Override
    public void run() {
        while (true) {
            if (method()) break;
        }
    }

    // 锁对象为：this
    private synchronized boolean method() {
        if (tickets == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + tickets + "张票");
        }
        return false;
    }
}
