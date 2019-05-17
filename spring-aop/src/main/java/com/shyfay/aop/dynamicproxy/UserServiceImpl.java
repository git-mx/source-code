package com.shyfay.aop.dynamicproxy;

/**
 * @author mx
 * @since 2019/5/13
 */
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("add...");
    }
}
