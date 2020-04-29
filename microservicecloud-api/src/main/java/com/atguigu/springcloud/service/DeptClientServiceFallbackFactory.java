package com.atguigu.springcloud.service;
import com.atguigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该id"+id+"没有对应信息，consumer客户端提供了降级信息，此刻provider已经关闭")
                        .setDb_source("no detail info in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
