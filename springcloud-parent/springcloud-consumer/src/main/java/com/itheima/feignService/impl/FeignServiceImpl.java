package com.itheima.feignService.impl;

import com.itheima.domain.User;
import com.itheima.feignService.FeignService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeignServiceImpl implements FeignService {

    /**
     * feign的实现类中的实现方法，就是熔断降级的回调方法
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("服务器繁忙，请稍后重试！");
        users.add(user);
        return users;
    }
}
