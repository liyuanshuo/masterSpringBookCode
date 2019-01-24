package com.cqu.aspectj.basic;

import com.cqu.Seller;
import com.cqu.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:46
 * @description :  add description here
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value="com.cqu.NaiveWaiter",
            defaultImpl= SmartSeller.class)
    public Seller seller;
}
