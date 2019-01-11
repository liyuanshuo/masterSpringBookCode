package com.liyuanshuo.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 20:23
 * @description :  add description here
 */
public class SimpleTest {

    public static void main(String[] args) throws Throwable{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        LogonService logonService = ctx.getBean(LogonService.class);
        Assert.notNull(logonService, "logonService null ?");
        logonService.saveLog();
        Assert.notNull(logonService, "logonService null ?");
    }
}
