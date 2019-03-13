package com.my.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon消费服务
 * Created by lzt on 2019/3/13.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiServies(String name) {
        //多次访问http://localhost:4444/hi?name=my
        //轮番出现 123 124 2222等接口：hi my ,i am from port:2222
        //基本实现了负载均衡
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
}
