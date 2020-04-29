package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    /**
     *  boot--->逐渐优化spring框架， applicationContext.xml
     *  用 @Configuration 注解的 ConfigBean   相当于  applicationContext.xml
     */
    @Bean
    @LoadBalanced //spring Cloud Ribbon 是基于Netflix Ribbon实现的一套 客户端负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){
//      // return new RandomRule();
//        return new RetryRule();
//    }
}
