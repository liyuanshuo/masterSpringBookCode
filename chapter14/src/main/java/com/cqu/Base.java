package com.cqu;

import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 15:59
 * @description :  add description here
 */
public class Base<T> {
    public <T> List getEntity(Class<T> entity, int id){
        return Mock.getList(entity);
    }
}
