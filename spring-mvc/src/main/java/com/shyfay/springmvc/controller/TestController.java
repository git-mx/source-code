package com.shyfay.springmvc.controller;

import com.shyfay.springmvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mx
 * @since 2019/4/25
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    public String test1(){
        return testService.test3();
    }
}
