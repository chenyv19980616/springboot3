package com.atguigu.dto;

import lombok.Data;

/**
 * @author : chenyv
 * @description : 员工DTO
 * @since : 2023-12-08 00:55
 */
@Data
public class Employee {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
