package com.atguigu.boot3.ssm.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:41:07
 **/
@Data
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hireDate;
    private String jobId;
    private Double salary;
    private Double commissionPct;
    private Long managerId;
    private Long departmentId;
}
