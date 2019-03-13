package com.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient/*注解@EnableEurekaClient表明是一个服务提供者*/
@RestController
public class SpringcloudclietApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudclietApplication.class, args);
	}


	@Value("${server.port}")
	private String port;

	/**
	 * 浏览器输入http://localhost:2222/hi
	 * @param name
	 * @return
	 */
	@RequestMapping("/hi")
	public String test(@RequestParam(value = "name", defaultValue = "forezp") String name){
		return "hi " + name + " ,i am from port:" + port;
	}

}
