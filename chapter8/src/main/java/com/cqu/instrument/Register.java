package com.cqu.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:58
 * @description :  add description here
 */
public class Register {
    public static void premain(String agentArgs, Instrumentation inst) {
        ClassFileTransformer t = new Transformer();
        inst.addTransformer(t);
    }
}
