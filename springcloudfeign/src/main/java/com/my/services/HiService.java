package com.my.services;

import com.my.hystric.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign是自带断路器的，在D版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下代码：
 * 1 Feign中使用断路器
 * feign: hystrix: enabled: true
 * 2 新增接口实现类SchedualServiceHiHystric
 * 3 @FeignClient的fallback指定到实现类
 * Created by lzt on 2019/3/13.
 */
@FeignClient(name = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface HiService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name") String name);
}
