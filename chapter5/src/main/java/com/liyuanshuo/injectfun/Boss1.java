package com.liyuanshuo.injectfun;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 16:17
 * @description :  add description here
 */
public class Boss1 implements MagicBoss {
    public Car getCar() {
        Car car = new Car();
        car.setBrand("Boss1CarBrand");
        return car;
    }
}
