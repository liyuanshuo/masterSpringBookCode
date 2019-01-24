package com.cqu.schema;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 16:01
 * @description :  add description here
 */
public class TestBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("------TestBeforeAdvice------");
        System.out.println("clientName:"+objects[0]);
        System.out.println("------TestBeforeAdvice------");
    }
}
