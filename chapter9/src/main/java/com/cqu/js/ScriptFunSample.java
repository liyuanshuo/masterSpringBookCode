package com.cqu.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:21
 * @description :  add description here
 */
public class ScriptFunSample {
    public static void main(String[] args) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scriptText = "function sum(a,b) { return a+b; } ";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("sum", 99,99);
        System.out.println(result);
    }
}
