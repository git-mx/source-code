package com.shyfay.bean.qualifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author mx
 * @since 2019/4/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:qualifier-beans.xml")
public class QualifierTestTest  extends AbstractJUnit4SpringContextTests {

    @Autowired
    QualifierTest qualifierTest;

    @Test
    public void getFruit() {
        Fruit apple =qualifierTest.getApple();
        apple.name();
        Fruit bananer =qualifierTest.getBananer();
        bananer.name();
    }
}