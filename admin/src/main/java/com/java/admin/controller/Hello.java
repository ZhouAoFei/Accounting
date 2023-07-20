package com.java.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("请求接受！");
        return "Hello SpringBoot";
    }
}
