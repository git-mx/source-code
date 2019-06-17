package com.shyfay.rmi.server;

/**
 * @author mx
 * @since 2019/5/30
 */
public class TestRmiServiceImpl implements TestRmiService {
    public int add(int a, int b) {
        return a + b;
    }
}
