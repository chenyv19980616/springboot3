package com.atguigu.web.controller;

import com.atguigu.web.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenyv
 * @since :  2024-03-05 17:21:58
 **/
@RestController
public class HelloController {

    @GetMapping("/person")
    public Person person(){
        Person person = new Person();
        person.setId(1L);
        person.setUserName("chenyv");
        person.setEmail("chenyv@gmail.com");
        person.setAge(20);
        return person;
    }
}
