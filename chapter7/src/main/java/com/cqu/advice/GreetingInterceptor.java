package com.cqu.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 18:57
 * @description :  add description here
 */
public class GreetingInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("How are you ? Mr." + clientName + ".");

        Object object = methodInvocation.proceed();
        System.out.println("Please enjoy yourself");

        return object;
    }
}
