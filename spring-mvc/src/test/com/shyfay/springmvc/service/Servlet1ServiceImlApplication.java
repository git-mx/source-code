package com.shyfay.springmvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 单元测试类
 * @author mx
 * @since 2019/4/25
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Servlet1ServiceImlApplication extends AbstractJUnit4SpringContextTests {


    @Autowired
    TestService testService;

    @Test
    public void test1() {
        testService.test1();
    }

    @Test
    public void test2() {
        testService.test2();
    }
}
