package com.cqu.autoproxy;

import com.cqu.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 14:19
 * @description :  add description here
 */
public class AopAwareTest {
    @Test
    public void testAutoProxy(){
        String configPath = "com/cqu/autoproxy/beans-aware.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.serveTo("john");
    }
}
