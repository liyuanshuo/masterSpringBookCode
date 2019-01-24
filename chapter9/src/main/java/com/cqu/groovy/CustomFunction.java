package com.cqu.groovy;

import groovy.lang.Script;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:19
 * @description :  add description here
 */
public class CustomFunction extends Script {
    @Override
    public Object run() {
        Method[] methods = CustomFunction.class.getDeclaredMethods();
        StringBuilder sb=new StringBuilder();
        for (Method method : methods) {
            sb.append(method);
        }
        return sb.substring(0, sb.length()-1);
    }

    public static Object nvl(Object str, Object val) {
        return str == null || "".equals(str) ? val : str;
    }
}
