package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后，会自动注册进eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //添加对Hystrix熔断机制支持
public class DeptProvider8001_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
