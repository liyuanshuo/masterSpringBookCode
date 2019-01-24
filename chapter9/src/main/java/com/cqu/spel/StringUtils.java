package com.cqu.spel;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:48
 * @description :  add description here
 */
public class StringUtils {
    public static String reverseString(String input) {
        StringBuilder backwards = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            backwards.append(input.charAt(input.length() - 1 - i));
        }

        return backwards.toString();

    }
}
