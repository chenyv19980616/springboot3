package com.atguigu.waitnotify01;

/**
 * @author : chenyv
 * @since : 2024-04-09 23:37
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Cooker cooker = new Cooker();
        cooker.setName("cooker");
        Eater eater = new Eater();
        eater.setName("eater");

        cooker.start();
        eater.start();
    }
}
