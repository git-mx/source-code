package com.shyfay.aop.cglib;


import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB是一个强大的高性能的代码生成包。它广泛地被许多AOP框架使用，例如SpringAOP和dynaop，为他们提供方法的拦截
 * Interceptor。最流行的OR Mapping工具Hibernate也使用cglib来代理单端关联；EasyMock和jMock是通过使用模仿
 * 对象来测试java包的，它们都是通过使用CGLIB类似为那些没有实现任何接口的类创建模仿对象。
 * CGLIB包的底层是通过使用一个小儿快的字节码处理框架ASM来转换字节码并生成代理类。除了CGLIB包，脚本语言Groovy和
 * BeanShell也是使用ASM来生成java的字节码。当然不鼓励直接使用ASM，因为它要求你必须对JVM的内部结构（包括class文件
 * 格式和指令集）都非常熟悉。
 * @author mx
 * @since 2019/5/13
 */
public class MainTest {
    public void test(){
        System.out.println("Enchancer test...");
    }
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MainTest.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        MainTest mt = (MainTest)enhancer.create();
        mt.test();
        System.out.println(mt);
    }
}
