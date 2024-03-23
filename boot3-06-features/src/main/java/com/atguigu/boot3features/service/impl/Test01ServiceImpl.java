package com.atguigu.boot3features.service.impl;

import com.atguigu.boot3features.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author : chenyv
 * @since : 2024-03-23 15:56
 */
@Service
public class Test01ServiceImpl implements TestService {
    @Override
    public Integer test01() {
        return 200;
    }
}
