package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/list")
    public List<User> list(){
        List<User> users = new ArrayList<User>();
        users.add(new User("zhangsan","shenzhen","123"));
        users.add(new User("lisi","beijing","456"));
        users.add(new User("wangwu","wuhan","789"));

        return users;
    }
}
