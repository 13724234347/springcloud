package com.tzh.controller;

import com.tzh.entity.User;
import com.tzh.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {


    @Resource
    private UserFeignClient userFeignClient;


    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/queryAll")
    public List<User> queryAll() {
        return this.userFeignClient.queryAll();
    }

    @GetMapping("/addUser")
    public void addUser(){
        this.userFeignClient.addUser();
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userFeignClient.deleteUser(id);
    }

    @GetMapping("/updata/{id}")
    public void updataUser(@PathVariable Long id){
        this.userFeignClient.updataUser(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return this.userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return this.userFeignClient.getUser(user);
    }


}
