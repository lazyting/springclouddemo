package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过@EnableEurekaClient向服务中心注册
 * ribbon添加断路器
 * 1，在程序的启动类ServiceRibbonApplication 加@EnableHystrix注解开启Hystrix(断路器)
 * 2，改造service类，在service方法上加上@HystrixCommand注解
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class SpringcloudribbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudribbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
