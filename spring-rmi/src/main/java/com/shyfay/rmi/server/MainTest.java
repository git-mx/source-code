package com.shyfay.rmi.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 先启动这个类，启动之后呈现会在9000端口作为java服务一直运行
 * @author mx
 * @since 2019/5/30
 */
public class MainTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("server.xml");
    }
}
