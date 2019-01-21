package com.liyuanshuo.place;

import com.liyuanshuo.placeholder.MyDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 21:29
 * @description :  add description here
 */
public class PlaceHolderTest {

    @Test
    public void hold() throws Throwable {
        String resourceFile = "com/liyuanshuo/placeholder/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        DataSource ds = ctx.getBean(DataSource.class);
        Connection conn = ds.getConnection();
        assertNotNull(conn);
        System.out.println(ctx.getBean(MyDataSource.class));
    }
}
