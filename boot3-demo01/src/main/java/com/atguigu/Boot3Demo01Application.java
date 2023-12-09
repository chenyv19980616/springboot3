package com.atguigu;

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
        SpringApplication.run(Boot3Demo01Application.class, args);
    }

}
