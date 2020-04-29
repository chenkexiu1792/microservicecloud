package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
/**
 * 部门微服务
 */
@RestController
public class DeptController_Feign_Consumer {
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";//通过微服务的真实名字，获得访问
    /**
     * 使用RestTemplate非常简单粗暴 （url，RequestMap，ResponseBean.class）
     * 这三个参数分别代表 Rest 请求地址，请求参数，以及HTTP响应转换成对象类型；
     */
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient client;
    @RequestMapping("/consumer/dept/get/{id}")
    public  Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery/",Object.class);
    }
}
