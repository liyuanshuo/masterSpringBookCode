package com.cqu.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 14:23
 * @description :  add description here
 */
public class ForumServiceTest {
    @Test
    public void testProxy(){
        // 业务类正常编码的测试
//         ForumService forumService = new ForumServiceImpl();
////         forumService.removeForum(10);
////         forumService.removeTopic(1012);

        // 使用JDK动态代理
//		ForumService target = new ForumServiceImpl();
//		PerformaceHandler handler = new PerformaceHandler(target);
//		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
//				.getClass().getClassLoader(),
//				target.getClass().getInterfaces(), handler);
//		proxy.removeForum(10);
//		proxy.removeTopic(1012);

        //使用CGLib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
