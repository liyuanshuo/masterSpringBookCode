package com.liyuanshuo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 20:22
 * @description :  add description here
 */
class MailSendEvent extends ApplicationEvent {

    private String to;

    MailSendEvent(Object source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return to;
    }
}
