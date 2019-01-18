package com.liyuanshuo.ditype;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 19:50
 * @description :  add description here
 */
public class Boss {
    private String name;
    private Car car;
    private Office office;

    public Boss(String name, Car car, Office office) {
        this.name = name;
        this.car = car;
        this.office = office;
    }

    public Boss(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Boss() {
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
                ", office=" + office +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
