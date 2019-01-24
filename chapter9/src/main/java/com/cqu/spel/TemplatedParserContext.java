package com.cqu.spel;

import org.springframework.expression.ParserContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:23
 * @description :  add description here
 */
public class TemplatedParserContext implements ParserContext {
    @Override
    public boolean isTemplate() {
        return true;
    }

    @Override
    public String getExpressionPrefix() {
        return "${";
    }

    @Override
    public String getExpressionSuffix() {
        return "}";
    }
}
