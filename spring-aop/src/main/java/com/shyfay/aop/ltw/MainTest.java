package com.shyfay.aop.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LTW load time weaving 加载时织入
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
