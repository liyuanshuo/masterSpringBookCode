package com.cqu;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 15:19
 * @description :  add description here
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional("topic")
public @interface TopicTransactional {
}
