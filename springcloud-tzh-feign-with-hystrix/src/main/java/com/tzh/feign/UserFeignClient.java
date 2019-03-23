package com.tzh.feign;

import com.tzh.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//下面fallback属性还有一个升级版为fallbackFactory属性，两者不能同时存在,fallbackFactory不但可以重写方法,还可以打印日志
@FeignClient(name = "springcloud-tzh-user",fallback = HystrixClientFallback.class) // 提供者yml中application:name:的值
public interface UserFeignClient {

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id);

}
