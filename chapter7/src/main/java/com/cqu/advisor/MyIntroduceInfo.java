package com.cqu.advisor;

import com.cqu.introduce.Monitorable;
import org.springframework.aop.support.IntroductionInfoSupport;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:15
 * @description :  add description here
 */
public class MyIntroduceInfo extends IntroductionInfoSupport {
    public MyIntroduceInfo() {
        super();
        super.publishedInterfaces.add(Monitorable.class);
    }
}
