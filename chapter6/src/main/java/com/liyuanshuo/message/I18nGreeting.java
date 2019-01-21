package com.liyuanshuo.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 20:44
 * @description :  add description here
 */
class messageGreeting {
    private static void rsrBdlMessageResource(){
        String[] configs = {"com/liyuanshuo/message/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);

        MessageSource ms = (MessageSource)ctx.getBean("myResource1");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = (String) ms.getMessage("greeting.common",params, Locale.US);
        String str2 = (String) ms.getMessage("greeting.morning",params,Locale.CHINA);
        String str3 = (String) ms.getMessage("greeting.afternoon",params,Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }
    public static void rrsrBdlMessageResource() throws Exception{
        String[] configs = {"com/liyuanshuo/message/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);

        MessageSource ms = (MessageSource)ctx.getBean("myResource2");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        for (int i = 0; i < 2; i++) {
            String str1 = ms.getMessage("greeting.common",params,Locale.US);
            System.out.println(str1);
            Thread.sleep(20000);
        }
    }

    private static void ctxMessageResource() throws Exception{
        String[] configs = {"com/liyuanshuo/message/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = ctx.getMessage("greeting.common",params,Locale.US);
        String str2 = ctx.getMessage("greeting.morning",params,Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void main(String[] args) throws Exception{
//		rsrBdlMessageResource();
//		rrsrBdlMessageResource();
        ctxMessageResource();
    }
}
