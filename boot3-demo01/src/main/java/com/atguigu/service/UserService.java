package com.atguigu.service;

import com.atguigu.dto.User;

/**
 * @author : chenyv
 * @description : 服务层
 * @since : 2023-12-05 21:20
 */
public interface UserService {
    public Boolean saveToRedis(User user);
}
