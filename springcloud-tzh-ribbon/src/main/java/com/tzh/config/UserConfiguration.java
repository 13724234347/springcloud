package com.tzh.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class UserConfiguration {
    //  @Autowired
    //  IClientConfig config;

    //随机机制
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
