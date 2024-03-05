package com.atguigu.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author : chenyv
 * @since :  2024-03-05 17:17:05
 **/
@Data
@JacksonXmlRootElement
public class Person {
    private Long id;
    private String userName;
    private String email;
    private Integer age;
}
