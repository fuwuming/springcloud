package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.feignService.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/feign")
    public List<User> feign(){
        return feignService.findAll();
    }
}
