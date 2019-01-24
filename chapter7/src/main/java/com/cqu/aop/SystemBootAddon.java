package com.cqu.aop;

import org.springframework.core.Ordered;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 20:08
 * @description :  add description here
 */
public interface SystemBootAddon extends Ordered {


    /**在系统就绪后调用的方法**/
    void onReady();
}
