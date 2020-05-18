package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RefreshScope //同步刷新配置
public class UserController {

    @Autowired
    private UserService userService;

    @Value(value = "${test.message}")
    private String message;

    @RequestMapping(value = "/findAll")
    public List<User> findAll(){
        System.out.println(message);
        return userService.findAll();
    }
}
