package com.atguigu.controller;

import com.atguigu.dto.Employee;
import com.atguigu.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : chenyv
 * @description : 表现层
 * @since : 2023-12-05 21:19
 */
@RestController
public class EmployeeController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/queryEmployees")
    public List<Employee> queryEmployees(@RequestBody Employee employee) {
        return employeeService.queryEmployeeList(employee);
    }

    @PostMapping("/queryDepartment")
    public List<Employee> queryDepartment(@RequestBody Employee employee) {
        return null;
    }

    @GetMapping("/get/{key}")
    public Object get(@PathVariable String key){
        return redisTemplate.opsForValue().get(key);
    }

    @PostMapping("/set/{key}/{value}")
    public String set(@PathVariable String key,
                      @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success！";
    }

    @GetMapping("/getEmp/{id}")
    public Object getEmp(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

}
