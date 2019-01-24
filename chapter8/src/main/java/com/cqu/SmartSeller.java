package com.cqu;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:51
 * @description :  add description here
 */
public class SmartSeller implements Seller {
    public int sell(String goods, String clientName) {
        System.out.println("SmartSeller: sell "+goods +" to "+clientName+"...");
        return 100;
    }

    public void checkBill(int billId){
        if(billId == 1) {
            throw new IllegalArgumentException("iae Exception");
        } else {
            throw new RuntimeException("re Exception");
        }
    }
}
