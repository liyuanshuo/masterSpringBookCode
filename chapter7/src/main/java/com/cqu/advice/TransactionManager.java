package com.cqu.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 18:52
 * @description :  add description here
 */
public class TransactionManager implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("------------------------");
        System.out.println("method : " + method.getName());
        System.out.println("抛出异常：" + ex.getMessage());
        System.out.println("成功回滚事务.....");
    }
}
