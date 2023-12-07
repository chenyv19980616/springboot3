package com.atguigu.service;

import com.atguigu.dto.Employee;

/**
 * @author : chenyv
 * @description : 服务层
 * @since : 2023-12-05 21:20
 */
public interface EmployeeService {

    public Boolean saveToRedis(Employee employee);
}
