package com.shyfay.springmvc.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * 全局IOC容器-测试接口实现类，注意这里没有写@Service注解，是写到applicationContext.xml配置文件里面的
 *
 * @author mx
 * @since 2019/4/25
 */
@Service
public class TestServiceIml implements TestService {
    @Override
    public void test1() {
        System.out.println("this is test1...");
        //test2();
        //将applicationContext.xml里面的aop的expose-proxy设置成true
        //并将test2()，改成如下形式，那么在执行test2之前也会执行doBefore方法。否则在test1里面
        //调用test2是不会指定doBefore的。Spring推荐的最佳方式是在AOP作用的类里面，最好不要使用内部类
        ((TestService) AopContext.currentProxy()).test2();
    }

    @Override
    public void test2() {
        System.out.println("this is test2...");
    }

    @Override
    public String test3() {
        return "test3";
    }
}
