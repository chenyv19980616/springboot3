package com.atguigu.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.dto.User;
import com.atguigu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : chenyv
 * @description :
 * @since : 2023-12-05 21:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Boolean saveToRedis(User user) {
        redisTemplate.opsForValue().set("user1", JSON.toJSONString(user));
        return true;
    }
}
