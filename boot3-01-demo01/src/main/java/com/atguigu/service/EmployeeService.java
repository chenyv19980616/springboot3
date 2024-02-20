package com.atguigu.service;

import com.atguigu.dto.Employee;

import java.util.List;

/**
* @author chenyv
* @description 针对表【employees】的数据库操作Service
* @createDate 2023-12-08 01:13:03
*/
public interface EmployeeService{

    /**
     * 查询所有员工
     * @param employee
     * @return
     */
    List<Employee> queryEmployeeList(Employee employee);

    Object getById(Integer id);
}
