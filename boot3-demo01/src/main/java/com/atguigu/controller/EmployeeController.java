package com.atguigu.controller;

import com.atguigu.dto.Employee;
import com.atguigu.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : chenyv
 * @description : 表现层
 * @since : 2023-12-05 21:19
 */
@RestController
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @PostMapping("/query")
    public List<Employee> query(@RequestBody Employee employee) {
        return employeeService.queryEmployeeList(employee);
    }

}
