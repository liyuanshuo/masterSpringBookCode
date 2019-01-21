package com.liyuanshuo.editor;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 19:56
 * @description :  add description here
 */
public class Boss {
    private String name;
    private Car car = new Car();

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
