package com.atguigu.service;

import com.atguigu.dto.Employee;

/**
* @author chenyv
* @description 针对表【employees】的数据库操作Service
* @createDate 2023-12-08 01:13:03
*/
public interface EmployeeService{

    Boolean saveToRedis(Employee employee);
}
