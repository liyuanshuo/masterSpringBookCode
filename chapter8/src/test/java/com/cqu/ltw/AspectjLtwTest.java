package com.cqu.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 16:36
 * @description :  add description here
 */
public class AspectjLtwTest {
    @Test
    public void testMain(){
        String configPath = "com/cqu/ltw/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = ctx.getBean(Waiter.class);
        waiter.greetTo("John");
        waiter.serveTo("John");
    }
}
