package com.shyfay.mybatis;

import com.shyfay.mybatis.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 本例用于测试spring集成mybatis
 * @author mx
 * @since 2019/5/22
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        UserMapper userMapper = ctx.getBean("userMapper", UserMapper.class);
        System.out.println(userMapper.get(1));
    }
}
