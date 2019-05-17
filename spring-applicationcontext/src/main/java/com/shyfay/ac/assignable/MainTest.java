package com.shyfay.ac.assignable;

import java.util.ArrayList;

/**
 * class的isAssignableFrom方法
 * 如果调用该方法的class与参数class一样或者是参数class的父类，则返回true
 * 功能有点类似于instanceOf
 * @author mx
 * @since 2019/5/13
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println(Object.class.isAssignableFrom(ArrayList.class));
    }
}
