package com.cqu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 16:01
 * @description :  add description here
 */
public class Mock {
    public static List getList(Class entity){
        List list = new ArrayList();
        try {
            list.add(entity.newInstance());
            list.add(entity.newInstance());
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        for (String string: list) {
            System.out.println(string);
        }
    }
}
