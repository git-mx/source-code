package com.shyfay.agent;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;
/**
 * @author mx
 * @since 2019/5/14
 */
public class PerfMonAgent {
    private static Instrumentation inst = null;
    public static void premain(String agentArgs, Instrumentation _inst){
        System.out.println("PerfMonAgent.premain() was called...");
        inst = _inst;
        ClassFileTransformer transformer = new PerfMonXformer();
        System.out.println("Added a new PerfMonXformer to the JVM...");
        inst.addTransformer(transformer);
    }
}
