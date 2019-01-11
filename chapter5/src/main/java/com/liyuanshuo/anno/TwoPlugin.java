package com.liyuanshuo.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:37
 * @description :  add description here
 */
@Component
@Order(value = 2)
public class TwoPlugin implements Plugin {
}
