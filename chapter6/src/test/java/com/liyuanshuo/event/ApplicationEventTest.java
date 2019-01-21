package com.liyuanshuo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 20:26
 * @description :  add description here
 */
public class ApplicationEventTest {

    @Test
    public void test(){
        String resourceFile = "com/liyuanshuo/event/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resourceFile);
        MailSender mailSender = context.getBean(MailSender.class);
        mailSender.sendMail("test mail....");
        System.out.println("done....");
    }
}
