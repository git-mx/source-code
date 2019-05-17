package com.shyfay.aop.aop;

import lombok.Data;

/**
 * @author mx
 * @since 2019/5/13
 */
@Data
public class TestBean {
    private String testStr = "testStr";
    public void test(){
        System.out.println("test...");
    }
}
