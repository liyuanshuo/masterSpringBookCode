package com.cqu.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/13 17:54
 * @description :  add description here
 */
public class PropertyTest {

    private ApplicationContext context = null;
    private static String[] CONFIG_FILES = {"com/cqu/beans.xml"};

    @BeforeClass
    public void setUp(){
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCustomerCarEditer(){
        SystemPropertyBean systemPropertyBean = context.getBean(SystemPropertyBean.class);
//        MyDataSource dataSource = context.getBean(MyDataSource.class);
//        assertNotNull(dataSource);
        assertNotNull(systemPropertyBean);
    }
}
