package com.cqu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:35
 * @description :  add description here
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());

        Object result = methodProxy.invokeSuper(o, objects);

        PerformanceMonitor.end();
        return result;
    }
}
