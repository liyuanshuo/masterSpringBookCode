package com.cqu.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 16:07
 * @description :  add description here
 */
public class ToolTest {

    @Test
    public void testTool() {
        Class clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
