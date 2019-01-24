package com.cqu.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:10
 * @description :  add description here
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];
        System.out.println(o.getClass().getName() + "." + method.getName());
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
