package com.cqu.advisor;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:18
 * @description :  add description here
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("调用matches(method,clazz)对"+aClass.getName()+"."+method.getName()+"做动态检查.");
        String clientName = (String) objects[0];
        return specialClientList.contains(clientName);
    }
}
