package com.cqu.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:47
 * @description :  add description here
 */
public class SpelFunSample {
    public static void main(String[] args)throws Exception{

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("reverseString", StringUtils.class.getDeclaredMethod("reverseString", String.class));
        String helloWorldReversed = parser.parseExpression(
                "#reverseString('hello')").getValue(context, String.class);

        System.out.println("helloWorldReversed = "+helloWorldReversed);
    }
}
