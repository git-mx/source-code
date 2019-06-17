package com.shyfay.rmi.client;

import com.shyfay.rmi.server.TestRmiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 再启动这个类，调用9000端口的rmi服务
 * @author mx
 * @since 2019/5/30
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("client.xml");
        TestRmiService testRmiService = ctx.getBean("rmiClient", TestRmiService.class);
        System.out.println(testRmiService.add(1, 2));
    }
}
