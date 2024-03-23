package com.atguigu.boot3features.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Cat {
    private String name;
    private Integer age;
}