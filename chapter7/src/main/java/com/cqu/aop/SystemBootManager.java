package com.cqu.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 20:09
 * @description :  add description here
 */
@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<SystemBootAddon> systemBootAddons = Collections.EMPTY_LIST;

    private boolean hasRunOnce = false;

    @Autowired(required = false)
    public void setSystemBootAddons(List<SystemBootAddon> systemBootAddons) {
        Assert.notEmpty(systemBootAddons);
        OrderComparator.sort(systemBootAddons);
        this.systemBootAddons = systemBootAddons;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!hasRunOnce){
            for (SystemBootAddon systemBootAddon: systemBootAddons){
                systemBootAddon.onReady();
                if (logger.isDebugEnabled()){
                    logger.debug("执行插件：{}", systemBootAddon.getClass().getCanonicalName());
                }
            }
            hasRunOnce = true;
        } else {
            if (logger.isDebugEnabled()){
                logger.debug("已经执行过容器启动插件，本次忽略..........");
            }
        }
    }
}
