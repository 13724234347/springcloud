package com.tzh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tzh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hystrix/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack",commandProperties={@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://springcloud-tzh-user/user/" + id, User.class);
    }

    public User findByIdFallBack(Long id){
        User user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setName("liucong");
        Short i = 21;
        user.setAge(i);
        BigDecimal j = new BigDecimal(100.00);
        user.setBalance(j);
        return user;

    }


}
