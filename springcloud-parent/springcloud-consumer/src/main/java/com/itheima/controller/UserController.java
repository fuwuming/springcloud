package com.itheima.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "fallback")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand
    @RequestMapping(value = "/getAll")
    public String getAll(){
//        String url = "http://localhost:18081/user/findAll";\
        //获取实例列表
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("provider");
//        //实例信息
//        ServiceInstance serviceInstance = serviceInstances.get(0);

        String url = "http://provider/user/findAll";

        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }

    public String fallback(){
        return "服务器繁忙，请稍后重试！";
    }
}
