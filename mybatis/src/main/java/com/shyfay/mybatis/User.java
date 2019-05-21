package com.shyfay.mybatis;

import lombok.Data;

/**
 * @author mx
 * @since 2019/5/17
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String sex;

    public User(){}
    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
