package com.shyfay.springmvc.service;


/**
 * AOP的本质，动态代理，这个类就类似于AOP为目标类申请的代理类
 * proxy-target-class=false时，代理方式是使用JDK的动态代理来实现。这时如果被代理的对象如果实现了某个接口，Spring则会
 * 选择JDK动态代理策略动态的创建一个接口实现类（动态代理类）来代理目标对象，这时在动态代理类和实际被代理的对象类之间进行转换时
 * 会抛出java.lang.ClassCastException异常，这就是为什么不将proxy-target-class设置为true时，找不到bean的原因
 * proxy-target-class=true时，如果被代理的对象实现了至少一个接口，则会使用JDK动态代理，所有该目标类实现的接口都将被代理。
 * 如果被代理的对象没有实现任何接口，则创建一个CGLIB代理
 * @author mx
 * @since 2019/4/25
 */
public class TestServiceProxy implements TestService {

    private TestService testService;

    public void setTestService(TestService testService){
        this.testService = testService;
    }

    @Override
    public void test1() {
        this.doBefore();
        testService.test1();
    }

    @Override
    public void test2() {
        this.doBefore();
        testService.test2();
    }

    @Override
    public String test3() {
        return testService.test3();
    }

    private void doBefore() {
        System.out.println("do something before...");
    }
}
