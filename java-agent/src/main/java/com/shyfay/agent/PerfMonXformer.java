package com.shyfay.agent;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author mx
 * @since 2019/5/14
 */
public class PerfMonXformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] transformed = null;
        System.out.println("Transforming " + className);
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try{
            cl = pool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer));
            if (cl.isInterface() == false && className.equals("com/shyfay/agent/App")){
                CtMethod[] methods = cl.getDeclaredMethods();
                for(int i=0; i < methods.length; i++){
                    System.out.println("__________________________________");
                    methods[i].addLocalVariable("stime", CtClass.longType);
                    methods[i].insertBefore("long stime = System.nanoTime();");
                    methods[i].insertAfter("System.out.println(\"" + methods[i].getName() + ":\" + (System.nanoTime() - stime));");
                }
                transformed = cl.toBytecode();
            }
        }catch(Exception e){
            System.out.println("Could not instrument " + className + ", exception : " + e.getMessage());
        }finally {
            if (cl != null){
                cl.detach();
            }
        }
        return transformed;
    }
}
