package com.cqu.proxy;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:26
 * @description :  add description here
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();

    public static void begin(String method){
        System.out.println("begin monitor " + method + " ..........");
        MethodPerformace methodPerformace = performaceRecord.get();
        if (methodPerformace == null){
            methodPerformace = new MethodPerformace(method);
            performaceRecord.set(methodPerformace);
        } else {
            methodPerformace.reset(method);
        }
    }

    public static void end(){
        System.out.println("end monitor ..........");
        MethodPerformace methodPerformace = performaceRecord.get();
        methodPerformace.printPerformace();
    }

}
