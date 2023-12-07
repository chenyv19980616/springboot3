package com.atguigu.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.dto.Employee;
import com.atguigu.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : chenyv
 * @description :服务层
 * @since : 2023-12-05 21:22
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Boolean saveToRedis(Employee employee) {
        redisTemplate.opsForValue().set("user1", JSON.toJSONString(employee));
        return true;
    }
}
