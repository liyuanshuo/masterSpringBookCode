package com.cqu.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:56
 * @description :  add description here
 */
public class SpelHello {
    public static void main(String[] args) {
        ExpressionParser parser =new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello'+' World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
