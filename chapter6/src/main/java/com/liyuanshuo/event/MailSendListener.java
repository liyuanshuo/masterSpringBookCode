package com.liyuanshuo.event;

import org.springframework.context.ApplicationListener;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 20:24
 * @description :  add description here
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("MailSendListener:向" + mailSendEvent.getTo() + "发送完一封邮件");
    }
}
