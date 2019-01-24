package com.cqu.spel;

import com.cqu.PlaceOfBirth;
import com.cqu.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:30
 * @description :  add description here
 */
public class IfThenElseExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        String expression = "UserName == 'tom'? Credits+10:Credits";
        Integer credits = parser.parseExpression(expression).getValue(context, Integer.class);
        System.out.println(credits); // 110

    }
}
