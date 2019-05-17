package com.shyfay.aop.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mx
 * @since 2019/5/13
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        testBean.test();
    }
}
