package com.cqu.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:12
 * @description :  add description here
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

}
