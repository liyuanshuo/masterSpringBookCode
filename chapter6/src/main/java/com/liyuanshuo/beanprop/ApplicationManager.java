package com.liyuanshuo.beanprop;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 18:57
 * @description :  add description here
 */
@Component
public class ApplicationManager {

    @Value("#{sysConfig.sessionTimeout}")
    private Integer sessionTimeout;

    @Value("#{sysConfig.maxTabPageNum}")
    private Integer maxTabPagNum;

    public Integer getsessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public Integer getMaxTabPagNum() {
        return maxTabPagNum;
    }

    public void setMaxTabPagNum(Integer maxTabPagNum) {
        this.maxTabPagNum = maxTabPagNum;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
