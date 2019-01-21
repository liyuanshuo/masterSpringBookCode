package com.liyuanshuo.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 20:18
 * @description :  add description here
 */
public class MailSender implements ApplicationContextAware {

    private ApplicationContext context;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void sendMail(String to){
        System.out.println("MailSender : 模拟发送邮件......");
        MailSendEvent mailSendEvent = new MailSendEvent(this.context, to);
        context.publishEvent(mailSendEvent);
    }

}
