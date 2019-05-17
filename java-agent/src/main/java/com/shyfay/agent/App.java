package com.shyfay.agent;

/**
 * @author mx
 * @since 2019/5/14
 */
public class App {
    public void test(){
        System.out.println("Java Agent...");
    }

    public static void main(String[] args) {
        new com.shyfay.agent.App().test();
    }
}
