package com.cqu.mycache.cacheput;

import com.cqu.mycache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 16:49
 * @description :  add description here
 */
public class UserMain {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("cachePutUserServcie");
        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2;
        userFetch2 = userService.getUser(1);
        System.out.println(userFetch2);
    }
}