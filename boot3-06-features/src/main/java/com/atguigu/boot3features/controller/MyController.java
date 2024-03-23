package com.atguigu.boot3features.controller;

import com.atguigu.boot3features.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenyv
 * @since : 2024-03-23 17:38
 */
@Slf4j
@RestController
@RequestMapping("/myTest")
public class MyController {

    @PostMapping("/method01")
    public void method0101(){
        TestService test01 = (x, y) -> x * y;
        TestService test02 = (x, y) -> (x * x + y * y) - 1;

        log.info("test01={}", test01.calculate(1, 2));
        log.info("test02={}", test02.calculate(2, 3));
    }
}
