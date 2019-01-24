package com.cqu.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:51
 * @description :  add description here
 */
public class ComposableAdvisorTest {

    @Test
    public void testComposable(){
        String configPath = "com/cqu/advisor/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = context.getBean("waiter", Waiter.class);
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiterDelegate.service("Peter");
    }

}
