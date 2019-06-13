package com.tzh.controller;

import com.tzh.entity.User;
import com.tzh.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

  @Value("${spring.application.name}")
  private String application;

  @Autowired
  private UserRepository userRepository;

  
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findById(id).get();
  }

  @GetMapping("/queryAll")
  public List<User> queryAll(){
    return this.userRepository.findAll();
  }

  @PostMapping("/user")
  public User postUser(@RequestBody User user){
   return  user;
  }

}
