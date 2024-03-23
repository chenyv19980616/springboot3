package com.atguigu.boot3features.service;

/**
 * @author : chenyv
 * @since : 2024-03-23 15:51
 */
public interface TestService {

    Integer calculate(int a, int b);

    default Integer sum(Integer x, Integer y) {
        return x + y;
    }
}
