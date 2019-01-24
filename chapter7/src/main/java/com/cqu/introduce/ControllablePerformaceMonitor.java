package com.cqu.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:41
 * @description :  add description here
 */
public class ControllablePerformaceMonitor  extends DelegatingIntroductionInterceptor implements Monitorable, Testable {

    private  ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    public void test() {
        System.out.println("dd");
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object object = null;
        if (monitorStatusMap.get() != null && monitorStatusMap.get()){
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            object = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            object = super.invoke(mi);
        }
        return object;
    }
}
