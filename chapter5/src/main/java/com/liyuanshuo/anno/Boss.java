package com.liyuanshuo.anno;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:24
 * @description :  add description here
 */
@Component
public class Boss {
    private Car car;

    public Boss(){
        System.out.println("默认无参构造函数");
    }

    /**
    * 这里是private的方法
    * */
    @Resource
    private void setCar(Car car) {
        System.out.println("execute in setter");
        this.car = car;
    }

    @PostConstruct
    private void init1(){
        System.out.println("execute in init1");
    }

    @PostConstruct
    private void init2(){
        System.out.println("execute in init2");
    }

    @PreDestroy
    private void destroy1(){
        System.out.println("execute in destroy1");
    }

    @PreDestroy
    private void destroy2(){
        System.out.println("execute in destroy2");
    }
}
