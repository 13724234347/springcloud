package com.tzh.feign;

import com.tzh.entity.User;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class HystrixClientFallback implements UserFeignClient {


    @Override
    public User findById(Long id) {
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