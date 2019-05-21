package com.shyfay.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 本例用于演示spring-jdbc的用法，此时mybatis框架还没有介入
 * 其实sping-jdbc就是对jdbc（Java Data Base Connectivity, Java数据库连接）的封装，消除冗余代码
 * 简化开发
 * @author mx
 * @since 2019/5/17
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        User user = new User();
        user.setName("貂蝉");
        user.setAge(18);
        user.setSex("美女");
        userService.save(user);
        List<User> all = userService.geuAll();
        System.out.println(user);
        System.out.println(all);
    }
}
