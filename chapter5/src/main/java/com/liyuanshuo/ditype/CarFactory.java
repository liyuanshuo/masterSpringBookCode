package com.liyuanshuo.ditype;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 19:48
 * @description :  add description here
 */
public class CarFactory {

    public Car createHongQiCar(){
        Car car = new Car();
        car.setBrand("HongQiBrand");
        return car;
    }

    public static Car createCar(){
        return new Car();
    }
}
