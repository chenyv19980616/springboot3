package com.atguigu.boot3.ssm.bean;

import lombok.Data;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:41:07
 **/
@Data
public class Employee {
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
