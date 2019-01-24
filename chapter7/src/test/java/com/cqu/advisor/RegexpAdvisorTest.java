package com.cqu.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 14:06
 * @description :  add description here
 */
public class RegexpAdvisorTest {

    @Test
    public void testRegex(){
        String configPath = "com/cqu/advisor/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = context.getBean("waiter1", Waiter.class);
        waiter.greetTo("John");
        waiter.serveTo("John");
    }
}
