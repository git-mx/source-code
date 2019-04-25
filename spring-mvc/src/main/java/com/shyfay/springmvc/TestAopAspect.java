package com.shyfay.springmvc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 全局IOC容器-切面类
 *
 * @author mx
 * @since 2019/4/25
 */
@Aspect
//如果不在applicationContext.xml文件配置<bean id="aspect"/>的话需要@Commponent注解
//@Component
public class TestAopAspect {


    @Pointcut("execution(public * com.shyfay.springmvc.service.*.*(..))")
    public void dolog(){}

    @Before("dolog()")
    public void doBefore(){
        System.out.println("do something before...");
    }
}
