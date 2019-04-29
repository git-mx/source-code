package com.shyfay.ac.propertyeditor2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这里运行就不会报错
 *
 * @author mx
 * @since 2019/4/29
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("propertyeditor2.xml");
        UserManager um = context.getBean("userManager", UserManager.class);
        System.out.println(um.toString());
    }
}
