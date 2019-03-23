package com.tzh.feign;

import com.tzh.config.Configuration1;
import com.tzh.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;


@FeignClient(name = "springcloud-tzh-user" ,configuration = Configuration1.class) // 提供者yml中application:name:的值
public interface UserFeignClientTwo {

  @RequestLine("GET /user/{id}")
  public User findById(@Param("id") Long id);

  @RequestLine("GET /queryAll")
  public List<User> queryAll();


}
