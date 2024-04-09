package com.atguigu.waitnotify;

/**
* @author : chenyv
* @since : 2024-04-09 23:39
*/
public class Desk {
    // 表示桌子上是否有食物
    public static Integer foodFlag = 0;

    // 表示最多可以吃10碗
    public static Integer count = 10;

    // 锁对象
    public static Object lock = new Object();
}
