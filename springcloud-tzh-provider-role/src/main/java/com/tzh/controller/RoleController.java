package com.tzh.controller;

import com.tzh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RoleController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * ${user.userServicePath}代表访问提供者方法路径,在application.yml中 代表 http://localhost:7900/user/
     */
    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/role/{id}")
    public User findById(@PathVariable Long id) {
        //this.restTemplate.getForObject(你要访问的提供者的路径, 返回类型);
        //这里将路径拼接起来是为了接收访问路径要传的路径参数
        return this.restTemplate.getForObject(this.userServicePath + id, User.class);
    }
}
