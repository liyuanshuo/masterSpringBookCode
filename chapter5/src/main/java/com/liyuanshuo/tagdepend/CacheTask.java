package com.liyuanshuo.tagdepend;

import java.util.TimerTask;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 17:09
 * @description :  add description here
 */
public class CacheTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("doing clean cache");
    }
}
