package com.atguigu.boot3.ssm.controller;

import com.atguigu.boot3.ssm.bean.Employee;
import com.atguigu.boot3.ssm.dto.EmpReq;
import com.atguigu.boot3.ssm.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:56:00
 **/
@RestController
public class UserController {

    @Autowired
    EmployeeMapper employeeMapper;

    @PostMapping("/getEmployee")
    public Employee getUserById(@RequestBody EmpReq req){
        return employeeMapper.getEmployeeById(req.getEmployeeId());
    }

    @PostMapping("/getEmployees")
    public List<Employee> getEmployees(@RequestBody EmpReq req) {
        return employeeMapper.getEmployees(req);
    }

}

