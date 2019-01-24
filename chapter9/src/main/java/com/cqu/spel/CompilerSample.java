package com.cqu.spel;

import com.cqu.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:27
 * @description :  add description here
 */
public class CompilerSample {
    public static void main(String[] args) {
        User user = new User();
        SpelParserConfiguration configuration =
                new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, CompilerSample.class.getClassLoader());
        EvaluationContext context = new StandardEvaluationContext(user);
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        String expression = "isVipMember('tom') && isVipMember('jony')";
        SpelExpression spelExpression = parser.parseRaw(expression);
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
