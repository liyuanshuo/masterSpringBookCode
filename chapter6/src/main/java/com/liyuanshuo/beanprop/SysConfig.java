package com.liyuanshuo.beanprop;

import javax.sql.DataSource;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 18:42
 * @description :  add description here
 */
public class SysConfig {
    private Integer sessionTimeout;
    private Integer maxTabPageNum;

    private DataSource dataSource;

    public void initFromDB(){
        //从数据库获取属性配置值
        this.sessionTimeout = 30;
        this.maxTabPageNum = 10;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public Integer getMaxTabPageNum() {
        return maxTabPageNum;
    }

    public void setMaxTabPageNum(Integer maxTabPageNum) {
        this.maxTabPageNum = maxTabPageNum;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
