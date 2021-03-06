package com.cqu.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 14:16
 * @description :  add description here
 */
public class DynamicAdvisorTest {

    @Test
    public void testDynamic(){
        String configPath = "com/cqu/advisor/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = context.getBean("waiter2", Waiter.class);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }
}
