package com.shyfay.ac.converter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mx
 * @since 2019/4/30
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("converter.xml");
        UserManager userManager = ctx.getBean("userManager", UserManager.class);
        System.out.println(userManager.toString());
    }
}
