package com.springstudy.web;

import com.spring.study.module.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mx
 * @since 2019/6/16
 */
@RestController
public class TestController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    String home(){
        return helloService.sayHello();
    }
}