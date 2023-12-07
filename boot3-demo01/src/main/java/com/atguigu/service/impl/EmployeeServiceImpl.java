package com.atguigu.service.impl;

import com.atguigu.dto.Employee;
import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chenyv
* @description 针对表【employees】的数据库操作Service实现
* @createDate 2023-12-08 01:13:03
*/
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployeeList(Employee employee) {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeMapper.queryEmployeeList(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
}




