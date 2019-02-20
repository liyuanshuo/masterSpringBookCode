package com.cqu.mycache.initcache;

import com.cqu.mycache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 19:43
 * @description :  add description here
 */
public class UserMain {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService =  (UserService) context.getBean("initUserServcie");

        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(2);
        System.out.println(userFetch2);
    }
}
