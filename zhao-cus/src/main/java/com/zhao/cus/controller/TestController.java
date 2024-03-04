package com.zhao.cus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//开启配置自动更新
@RefreshScope
@RequestMapping("/cus")
public class TestController {
    @Value("${user.cus}")
    private String users;

    @GetMapping("/user")
    public String test1(){
        return users;
    }
}
