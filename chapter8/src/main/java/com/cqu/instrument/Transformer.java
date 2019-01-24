package com.cqu.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:57
 * @description :  add description here
 */
public class Transformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Hello " + className + "!");
//        return null;
        return new byte[0];
    }
}
