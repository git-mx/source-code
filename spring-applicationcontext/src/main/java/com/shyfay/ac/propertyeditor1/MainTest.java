package com.shyfay.ac.propertyeditor1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 运行程序会报错，因为在配置文件中是使用String来指定的类的Date属性
 *
 * @author mx
 * @since 2019/4/29
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("propertyeditor1.xml");
        UserManager um = context.getBean("userManager", UserManager.class);
        System.out.println(um.toString());
    }
}
