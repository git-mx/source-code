package com.shyfay.bean.initdestroy;

import lombok.Data;

/**
 * 用来演示bean的init-method和destroy-method属性
 * @author mx
 * @since 2019/4/28
 */
@Data
public class MethodBean {
    private String field1;
    private String field2;

    public void init(){
        System.out.println("this function will be executed when starting to initializating this bean...");
    }

    public void destroy(){
        System.out.println("this function will be executed when destory the bean ...");
    }
}
