package com.liyuanshuo.auto;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 17:23
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

    public Boss(String s) {
        this.name = s;
    }

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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", office=" + office +
                '}';
    }
}
