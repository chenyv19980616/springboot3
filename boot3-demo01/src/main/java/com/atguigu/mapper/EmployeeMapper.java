package com.atguigu.mapper;

import com.atguigu.dto.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chenyv
* @description 针对表【employees】的数据库操作Mapper
* @createDate 2023-12-08 02:15:19
* @Entity com.atguigu.dto.Employee
*/
public interface EmployeeMapper {

    /**
     * 查询所有员工
     * @param employee
     * @return
     */
    List<Employee> queryEmployeeList(Employee employee);

    Employee getById(@Param("id") Integer id);
}




