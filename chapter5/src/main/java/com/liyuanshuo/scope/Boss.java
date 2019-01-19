package com.liyuanshuo.scope;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 16:40
 * @description :  add description here
 */
public class Boss {
    private String name;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
