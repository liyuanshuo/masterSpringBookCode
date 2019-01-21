package com.liyuanshuo.beanprop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 19:46
 * @description :  add description here
 */
public class AnnoBeanPropReferenceTest {

    @Test
    public void test(){
        String resourceFile = "com/liyuanshuo/beanprop/beans1.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resourceFile);
        ApplicationManager applicationManager = context.getBean(ApplicationManager.class);
        assertNotNull(applicationManager);
        System.out.println(applicationManager);
    }

}
