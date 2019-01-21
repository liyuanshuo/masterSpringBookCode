package com.liyuanshuo.beanprop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 19:23
 * @description :  add description here
 */
public class BeanPropReferenceTest {

    @Test
    public void test() throws SQLException {
        String resourceFile = "com/liyuanshuo/beanprop/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resourceFile);
        DataSource dataSource = context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        assertNotNull(connection);
        System.out.println("connection is not null : " + (connection != null));
    }
}
