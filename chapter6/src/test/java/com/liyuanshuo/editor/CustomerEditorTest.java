package com.liyuanshuo.editor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 20:09
 * @description :  add description here
 */
public class CustomerEditorTest {

    private ApplicationContext context = null;

    private String[] CONFIG_FILES = {"com/liyuanshuo/editor/beans.xml"};

    @BeforeClass
    public void setUp(){
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCustomerCarEditor(){
        Boss boss = context.getBean("boss", Boss.class);
        assertNotNull(boss);
        System.out.println(boss);
    }
}
