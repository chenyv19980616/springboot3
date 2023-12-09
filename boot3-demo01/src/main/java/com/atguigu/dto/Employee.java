package com.atguigu.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenyv
 * @TableName employees
 */
@Data
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = -3345469171007835089L;
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

}