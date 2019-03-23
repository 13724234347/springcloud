package com.tzh.controller;

import com.tzh.entity.User;
import com.tzh.feign.UserFeignClientOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.tzh.feign.UserFeignClientTwo;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {


    @Resource
    private UserFeignClientTwo userFeignClientTwo;

    @Resource
    private UserFeignClientOne userFeignClientOne;



    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClientTwo.findById(id);
    }

    @GetMapping("/queryAllOne")
    public List<User> queryAllOne() {
        return this.userFeignClientOne.queryAll();
    }




    @GetMapping("/queryAllTwo")
    public List<User> queryAllTwo() {
        return this.userFeignClientTwo.queryAll();
    }


    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
        return this.userFeignClientOne.findServiceInfoFromEurekaByServiceName(serviceName);
    }




}
