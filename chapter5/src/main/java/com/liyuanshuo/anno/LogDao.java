package com.liyuanshuo.anno;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:38
 * @description :  add description here
 */
@Lazy
@Repository
public class LogDao implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("LogDao..........");
    }

    public void saveLog(){
        System.out.println("saveLog..........");
    }
}
