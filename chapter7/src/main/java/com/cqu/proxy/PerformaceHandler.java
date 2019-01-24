package com.cqu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:31
 * @description :  add description here
 */
public class PerformaceHandler implements InvocationHandler {

    private Object target;

    public PerformaceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object object = method.invoke(target, args);
        PerformanceMonitor.end();
        return object;

    }
}
