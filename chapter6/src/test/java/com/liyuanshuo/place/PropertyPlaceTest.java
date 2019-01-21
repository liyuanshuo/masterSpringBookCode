package com.liyuanshuo.place;

import com.liyuanshuo.placeholder.MyDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 21:32
 * @description :  add description here
 */
public class PropertyPlaceTest {

    public ApplicationContext ctx = null;

    private static String[] CONFIG_FILES = { "com/liyuanshuo/place/beans.xml" };

    @BeforeClass
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);

    }

    @Test
    public void testCustomerCarEditor(){
        MyDataSource dataSource = (MyDataSource)ctx.getBean(MyDataSource.class);
        System.out.println(dataSource);
        assertNotNull(dataSource);
    }
}
