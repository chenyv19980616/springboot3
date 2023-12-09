package com.atguigu.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.dto.Employee;
import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.service.EmployeeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chenyv
* @description 针对表【employees】的数据库操作Service实现
* @createDate 2023-12-08 01:13:03
*/
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

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

    @Override
    public Object getById(Integer id) {
        Object empObj = redisTemplate.opsForValue().get("Employee:" + id);
        if (empObj == null) {
            log.info("---Data From DataBase!---");
            Employee employee = employeeMapper.getById(id);
            redisTemplate.opsForValue().set("Employee:" + employee.getEmployeeId(), JSON.toJSON(employee));
            return employee;
        }
        return empObj;
    }
}




