package com.tzh.controller;


import com.tzh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/role/{id}")
    public User findById(@PathVariable Long id) {
        //路径使用http://springcloud-tzh-user/user/
        return this.restTemplate.getForObject("http://springcloud-tzh-user/user/" + id, User.class);
    }

    @GetMapping("/user")
    public String user() {
        //这里是我需要使用到那个微服务的application.name
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-tzh-user");
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        String value = "111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
        return value;
    }

}
