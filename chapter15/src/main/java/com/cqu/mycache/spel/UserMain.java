package com.cqu.mycache.spel;

import com.cqu.mycache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 19:49
 * @description :  add description here
 */
public class UserMain {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService =  (UserService) context.getBean("seplUserServcie");

        User user1 = new User("2", "w2",34);
        User userFetch1;
        userFetch1 = userService.getUser(user1);
        System.out.println(userFetch1);
        User userFetch2;
        userFetch2 = userService.getUser(user1);
        System.out.println(userFetch2);

        User user2;
        user2 = new User("1", "w1", 37);
        User userFetch3;
        userFetch3 = userService.getUser(user2);
        System.out.println(userFetch3);
        User userFetch4 = userService.getUser(user2);
        System.out.println(userFetch4);

    }
}
