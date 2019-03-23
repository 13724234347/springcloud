package com.tzh.feign;

import com.tzh.config.Configuration2;
import com.tzh.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface UserFeignClientOne {

    @RequestLine("GET /eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@Param("serviceName") String serviceName);

//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public void addUser();

    @RequestLine("GET /queryAll")
    public List<User> queryAll();

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User postUser(@RequestBody User user);
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    public void deleteUser(@PathVariable("id") Long id);
//
//    @RequestMapping(value = "/updata/{id}", method = RequestMethod.PUT)
//    public void updataUser(@PathVariable("id") Long id);



}
