package com.atguigu.service.impl;

import com.atguigu.dto.Employee;
import com.atguigu.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
* @author chenyv
* @description 针对表【employees】的数据库操作Service实现
* @createDate 2023-12-08 01:13:03
*/
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public Boolean saveToRedis(Employee employee) {
        return null;
    }
}




