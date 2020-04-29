package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 规则的类，不能放在主启动类包以及子包下
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule  myRule(){
        // return new RandomRule();//随机
        return new RandomRule_CP();
    }
}
