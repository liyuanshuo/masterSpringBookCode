package com.liyuanshuo.injectfun;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 16:17
 * @description :  add description here
 */
public class Boss2 implements MagicBoss, MethodReplacer {
    public Car getCar() {
        Car car = new Car();
        car.setBrand("Boss2CarBrand");
        return car;
    }

    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return getCar();
    }
}
