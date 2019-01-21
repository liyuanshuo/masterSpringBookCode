package com.liyuanshuo.editor;

import java.beans.PropertyEditorSupport;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 19:57
 * @description :  add description here
 */
public class CustomCarEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text){
        if ((text == null) || (!text.contains(","))){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }

        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        setValue(car);
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        if(value==null){
            return "";
        }else {
            Car car = (Car) value;
            return car.getBrand() + "  ,   " + car.getMaxSpeed() + "  ,  " + car.getPrice();
        }
    }
}
