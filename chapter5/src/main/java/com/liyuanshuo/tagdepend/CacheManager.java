package com.liyuanshuo.tagdepend;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 17:14
 * @description :  add description here
 */
public class CacheManager {
    public CacheManager() {
        AtomicReference<Timer> timer = new AtomicReference<Timer>(new Timer());
        TimerTask cacheTask = new CacheTask();
        timer.get().schedule(cacheTask,0,SystemSettings.REFRESH_CYCLE*1000);
    }
}
