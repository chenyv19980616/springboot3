package com.atguigu.boot3features.service.impl;

import com.atguigu.boot3features.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author : chenyv
 * @since : 2024-03-23 15:52
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public Integer test01() {
        return 100;
    }
}
