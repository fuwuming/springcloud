package com.itheima.feignService;

import com.itheima.domain.User;
import com.itheima.feignService.impl.FeignServiceImpl;
import com.itheima.util.FeignLoggerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "provider",
        fallback = FeignServiceImpl.class, //指定熔断降级的实现类
        configuration = FeignLoggerConfig.class) //指定feign日志级别的配置类
public interface FeignService {

    @RequestMapping(value = "/user/findAll")
    public List<User> findAll();
}
