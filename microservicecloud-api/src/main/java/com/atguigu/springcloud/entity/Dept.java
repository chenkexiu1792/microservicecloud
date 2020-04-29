package com.atguigu.springcloud.entity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * createDate: 2020年3月18日
 * author: Herman
 */
@SuppressWarnings("serial")
//@AllArgsConstructor
@NoArgsConstructor
//get set 方法
@Data
@Accessors(chain=true)
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    //代表来自哪个数据库，这条数据被存进哪个数据库
    private String db_source;
    public Dept(String dname) {
        this.dname = dname;
    }
    public static void main(String[] args) {
        Dept dept = new Dept();
        //链式处理
        dept.setDname("chenkexiu").setDeptno(117l).setDb_source("mysql01");
    }
}
