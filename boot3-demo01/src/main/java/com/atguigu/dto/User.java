package com.atguigu.dto;

import lombok.Data;

/**
 * @author : chenyv
 * @description :用户
 * @since : 2023-12-05 21:25
 */
@Data
public class User {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
