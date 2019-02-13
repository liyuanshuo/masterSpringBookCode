package com.cqu.spel;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:23
 * @description :  add description here
 */
public class CodeExprSample {

    public static String getBizCode() throws Exception{
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context= new StandardEvaluationContext();

        context.registerFunction("dim1", CodeGenerator.class.getDeclaredMethod("getDim1"));
        context.registerFunction("dim2", CodeGenerator.class.getDeclaredMethod("getDim2"));
        context.registerFunction("dim3", CodeGenerator.class.getDeclaredMethod("getDim3"));


        String codeExpr = "GS-${#dim1()}-000-${#dim2()}";
        Expression expression = parser.parseExpression(codeExpr, new TemplateParserContext());
        String code =expression.getValue(context,String.class);

        return code;
    }

    public static void main(String[] args) throws Exception{
        String bizCode = getBizCode();
        System.out.println(bizCode);
    }
}
