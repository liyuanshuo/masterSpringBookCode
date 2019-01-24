package com.cqu.aspectj.fun;

import com.cqu.Seller;
import com.cqu.SmartSeller;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:48
 * @description :  add description here
 */
public class EnableSellerAspect implements Ordered {
    @DeclareParents(value = "com.cqu.NaiveWaiter", defaultImpl = SmartSeller.class)
    public static Seller seller;
    public int getOrder() {
        return 2;
    }
}
