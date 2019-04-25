package com.shyfay.springmvc.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author mx
 * @since 2019/4/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestControllerTest  extends AbstractJUnit4SpringContextTests {

    @Autowired
    TestController testController;

    @Test
    public void test1() {
        System.out.println(testController.test1());
    }
}
