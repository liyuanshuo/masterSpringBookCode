package com.liyuanshuo.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 20:45
 * @description :  add description here
 */
@ContextConfiguration("classpath*:com.liyuanshuo.anno/mycomponent.xml")
public class MyComponentTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void load(){
        MyComponent myComponent = applicationContext.getBean(MyComponent.class);
        assertEquals(myComponent.getPlugins().size(), 2);
    }
}
