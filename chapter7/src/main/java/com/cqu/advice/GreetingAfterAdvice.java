package com.cqu.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 19:05
 * @description :  add description here
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself");
    }
}
