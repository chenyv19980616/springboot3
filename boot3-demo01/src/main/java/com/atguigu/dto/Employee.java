package com.atguigu.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName employees
 */
@TableName(value ="employees")
@Data
public class Employee implements Serializable {
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date hireDate;

    private String jobId;

    private Double salary;

    private Double commissionPct;

    private Integer managerId;

    private Integer departmentId;

    private static final long serialVersionUID = 1L;
}