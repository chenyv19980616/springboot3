package com.atguigu.waitnotify;

/**
 * @author : chenyv
 * @since : 2024-04-09 23:37
 */
public class Cooker extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {

                }
            }
        }
    }
}
