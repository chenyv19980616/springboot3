package com.atguigu.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenyv
 * @since :  2024-02-20 13:46:00
 **/
@Slf4j
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        log.info("哈哈哈哈");
        return "hello";
    }
}
