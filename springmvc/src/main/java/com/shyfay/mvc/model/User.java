package com.shyfay.mvc.model;

import lombok.Data;

/**
 * @author mx
 * @since 2019/5/17
 */
@Data
public class User {
    private String name;
    private String sex;

    public User(){}
    public User( String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
