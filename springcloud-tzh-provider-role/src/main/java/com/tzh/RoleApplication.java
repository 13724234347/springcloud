package com.tzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//消费者启动类,根据提供者的请求路径，你也可以请求到他的路劲
@SpringBootApplication
public class RoleApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RoleApplication.class,args);
    }
}
