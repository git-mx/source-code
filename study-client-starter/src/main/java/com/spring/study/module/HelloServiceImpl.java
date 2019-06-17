package com.spring.study.module;

import org.springframework.stereotype.Component;


/**
 * @author mx
 * @since 2019/6/16
 */
@Component
public class HelloServiceImpl implements HelloService {
    public String sayHello() {
        return "hello";
    }
}
