package com.cqu.concept;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:04
 * @description :  add description here
 */
public interface SecurityService {
    boolean chechAccess(User user, String service);
}
