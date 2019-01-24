package com.cqu.aspectj.basic;

import com.cqu.Seller;
import com.cqu.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 16:42
 * @description :  add description here
 */
public class DeclaredParentsTest {
    @Test
    public void testParent(){
        String configPath = "com/cqu/aspectj/basic/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
        Seller seller = (Seller)waiter;
        seller.sell("Beer", "John");
    }
}
