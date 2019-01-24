package com.cqu.autoproxy;

import com.cqu.advisor.Seller;
import com.cqu.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 14:21
 * @description :  add description here
 */
public class BeanNameAutoProxyCreatorTest {

    @Test
    public void testAutoProxy(){
        String configPath = "com/cqu/autoproxy/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter");
        Seller seller = (Seller) context.getBean("seller");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }
}
