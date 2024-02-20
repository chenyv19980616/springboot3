package com.atguigu;

import com.atguigu.dto.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenyv
 */
@SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class Boot3Demo01Application {
    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot3Demo01Application.class, args);
        Person person = ioc.getBean(Person.class);
        System.err.println("person = " + person);
    }

}
