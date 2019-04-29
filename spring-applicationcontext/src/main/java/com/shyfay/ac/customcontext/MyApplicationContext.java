package com.shyfay.ac.customcontext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mx
 * @since 2019/4/29
 */
public class MyApplicationContext extends ClassPathXmlApplicationContext {
    MyApplicationContext(String... configLocations){
        super(configLocations);
    }

    protected void initPropertySources(){
        getEnvironment().setRequiredProperties("VAR");
    }
}
