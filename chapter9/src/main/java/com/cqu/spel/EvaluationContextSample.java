package com.cqu.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:29
 * @description :  add description here
 */
public class EvaluationContextSample {
    static class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
    }


    public static void main(String[] args) {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        // false is passed in here as a string. SpEL and the conversion service will
        // correctly recognize that it needs to be a Boolean and convert it
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");
        // b will be false
        Boolean b = simple.booleanList.get(0);

        System.out.println(b);
    }
}
