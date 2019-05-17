package com.shyfay.aop.dynamicproxy;

/**
 * @author mx
 * @since 2019/5/13
 */
public class MainTest {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(us);
        UserService proxy = (UserService)myInvocationHandler.getProxy();
        proxy.add();
    }
}
