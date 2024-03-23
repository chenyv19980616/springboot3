package com.atguigu.boot3features.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
public class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text; // 数组
}