package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public List<User> findAll() throws Exception{
        Thread.sleep(5000);
        int i = 1/0;
        List<User> users = userService.findAll();
        for (User user : users) {
            user.setName("demo1");
        }
        return users;
    }
}
