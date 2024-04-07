package com.atguigu.thread03;

import java.util.concurrent.Callable;

/**
 * @author : chenyv
 * @since : 2024-04-07 23:43
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
