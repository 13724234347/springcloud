package com.tzh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//消费者启动类,根据提供者的请求路径，你也可以请求到他的路劲
@SpringBootApplication
@EnableEurekaClient
//使用自定义代码配置客户端负载均衡算法机制(随机机制,轮询机制,响应时间加权机制),还有一种配置文件(application.yml)实现方式(请参考配置文件)
//@RibbonClient(name = "microservice-provider-user", configuration = UserConfiguration.class)//随机机制,默认是轮询机制
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class RibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }
}
