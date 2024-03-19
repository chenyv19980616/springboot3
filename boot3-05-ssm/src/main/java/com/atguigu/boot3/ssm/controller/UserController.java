package com.atguigu.boot3.ssm.controller;

import com.atguigu.boot3.ssm.bean.Employee;
import com.atguigu.boot3.ssm.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:56:00
 **/
@RestController
public class UserController {

    @Autowired
    EmployeeMapper userMapper;

    @GetMapping("/employee/{id}")
    public Employee getUserById(@PathVariable("id") Long id){
        return userMapper.getEmployeeById(id);
    }
}

