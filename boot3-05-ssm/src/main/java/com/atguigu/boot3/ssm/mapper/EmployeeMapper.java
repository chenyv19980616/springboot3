package com.atguigu.boot3.ssm.mapper;

import com.atguigu.boot3.ssm.bean.Employee;
import com.atguigu.boot3.ssm.dto.EmpReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:42:22
 **/
public interface EmployeeMapper {
    Employee getEmployeeById(@Param("id") Long id);

    List<Employee> getEmployees(@Param("req") EmpReq req);
}
