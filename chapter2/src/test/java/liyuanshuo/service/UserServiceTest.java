package liyuanshuo.service;

import liyuanshuo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @Author : liyuanshuo
 * @Date : 2018/12/11 22:21
 * @Description :
 * @Version 1.0
 */
@ContextConfiguration("classpath*:/liyuanshuo-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "111111");
        assertTrue(b1);
        assertTrue(!b2);
    }


    @Test
    public void findUserByUserName(){
        User user = userService.findUserByName("admin");
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void testAddLoginLog(){
        User user = userService.findUserByName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.168.168");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }
}
