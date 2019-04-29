package com.shyfay.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author mx
 * @since 2019/4/29
 */
public class TestAware implements BeanFactoryAware {
    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testSay() {
        Hello hello = beanFactory.getBean("hello", Hello.class);
        hello.say();
    }
}
