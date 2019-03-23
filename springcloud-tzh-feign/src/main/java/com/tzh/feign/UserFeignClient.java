package com.tzh.feign;

import java.util.List;

import com.tzh.entity.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "springcloud-tzh-user") // 提供者yml中application:name:的值
public interface UserFeignClient {

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
  
  @RequestMapping(value="/queryAll",method = RequestMethod.GET)
  public List<User> queryAll();
  
  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public void addUser();
  
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public User postUser(@RequestBody User user);
  
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable("id") Long id);	
  
  @RequestMapping(value = "/updata/{id}", method = RequestMethod.PUT)
  public void updataUser(@PathVariable("id") Long id);	
  
  // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
  // 如勘误，请@lilizhou2008  eacdy0000@126.com
  //https://www.cnblogs.com/qq503665965/p/9865881.html 解决网页
  @RequestMapping(value = "/get-user", method = RequestMethod.GET)
  public User getUser(User user);
}
