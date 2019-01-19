package com.liyuanshuo.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 15:44
 * @description :  add description here
 */
public class LogonServiceTest {

    @Test
    public void getBean(){
        ApplicationContext context = new GenericGroovyApplicationContext("classpath:com/liyuanshuo/groovy/spring-context.groovy");
        LogDao logDao = context.getBean(LogDao.class);
        LogonService logonService = context.getBean(LogonService.class);
        assertNotNull(logonService);

        MailService mailService = context.getBean(MailService.class);
        assertNotNull(mailService);

        UserDao userDao = context.getBean(UserDao.class);
        assertTrue(userDao instanceof DbUserDao);
    }
}
