package com.cqu.aspectj.example;

import com.cqu.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 16:44
 * @description :  add description here
 */
public class AspectConfigTest {
    @Test
    public void testConfig(){
        String configPath = "com/cqu/aspectj/example/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.serveTo("John");
//        waiter.toString();
    }
}
