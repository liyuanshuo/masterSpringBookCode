package com.cqu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/16 15:10
 * @description :  add description here
 */
public class SimpleThreadLocal {
    private Map<Thread, Object> valueMap = Collections.synchronizedMap(new HashMap<Thread, Object>());
    public void set(Object newValue){
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get(){
        Thread currentThread = Thread.currentThread();
        Object object = valueMap.get(currentThread);
        if (object == null && !valueMap.containsKey(currentThread)){
            object = initialValue();
            valueMap.put(currentThread, object);
        }
        return object;
    }


    public void remove(){
        valueMap.remove(Thread.currentThread());
    }

    private Object initialValue() {
        return null;
    }


}
