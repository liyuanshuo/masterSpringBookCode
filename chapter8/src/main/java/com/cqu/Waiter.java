package com.cqu;

import com.cqu.anno.NeedTest;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:52
 * @description :  add description here
 */
public interface Waiter {
    @NeedTest
    public void greetTo(String clientName);
    public void serveTo(String clientName);
}
