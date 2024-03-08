package com.atguigu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:11:22
 **/
@Controller //适配服务端渲染
public class WelcomeController {
    @GetMapping("/well")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        // 模板的逻辑视图名
        return "welcome";
    }
}
