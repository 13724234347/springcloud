package com.tzh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    //必须要先请求该action，该action需要HystrixCommand注解
    @HystrixCommand(fallbackMethod="index")
    @GetMapping("/")
    public String index() {
        return "你好,我是sim-serviceE服务";
    }
}
