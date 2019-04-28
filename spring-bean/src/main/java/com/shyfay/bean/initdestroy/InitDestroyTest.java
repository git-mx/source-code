package com.shyfay.bean.initdestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用来演示bean的init-method和destroy-method属性
 *
 * @author mx
 * @since 2019/4/28
 */
public class InitDestroyTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("initdestroy-beans.xml");
        MethodBean methodBean = (MethodBean)context.getBean("methodBean");
        System.out.println(methodBean.getField1());
    }
}
