package com.atguigu.controller;

import com.atguigu.dto.User;
import com.atguigu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenyv
 * @description : 表现层
 * @since : 2023-12-05 21:19
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        Boolean isTrue = userService.saveToRedis(user);
        return isTrue ? "成功" : "失败";
    }

}
