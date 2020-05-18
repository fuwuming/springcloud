package com.itheima.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private RestTemplate restTemplate;

    @org.junit.Test
    public void testRestTemplate(){
        String url = "http://localhost:18081/user/list";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
    }
}
