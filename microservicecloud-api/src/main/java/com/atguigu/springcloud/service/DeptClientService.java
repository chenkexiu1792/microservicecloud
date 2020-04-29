package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 修改 microservicecloud-api，根据已有的DeptClientService接口，
 * 新建一个DeptClientServiceFallbackFactory
 */
//出现降级，统一由FallbackFactory 处理
@FeignClient(name = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value="/dept/add" ,method= RequestMethod.POST)
    public boolean add(Dept dept);

    @RequestMapping(value="/dept/get/{id}" ,method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value="/dept/list" ,method= RequestMethod.GET)
    public List<Dept> list();

}
