package com.shyfay.ac.processor1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author mx
 * @since 2019/4/29
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof User){
            System.out.println("we can do something before then bean initialization...");
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(o instanceof User){
            User user = (User) o;
            user.setName(user.getName().toUpperCase());
        }
        return o;
    }
}
