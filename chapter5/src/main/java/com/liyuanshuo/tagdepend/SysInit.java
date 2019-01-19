package com.liyuanshuo.tagdepend;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 17:10
 * @description :  add description here
 */
public class SysInit {
    public SysInit(){
        System.out.println("SysInit");
        //模拟从数据库中加载系统设置信息
        SystemSettings.REFRESH_CYCLE = 100;
        SystemSettings.SESSION_TIMEOUT = 10;
    }
}
