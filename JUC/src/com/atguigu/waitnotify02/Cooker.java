package com.atguigu.waitnotify02;

import java.util.concurrent.BlockingQueue;

/**
 * @author : chenyv
 * @since : 2024-04-11 21:16
 */
public class Cooker extends Thread {

    BlockingQueue<String> queue;

    public Cooker(BlockingQueue<String> queue) {
         this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.put("面条");
                System.out.println("厨师放了一碗面条！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
