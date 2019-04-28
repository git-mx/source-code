package com.shyfay.bean.custom;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 自定义标签测试主类
 *
 * @author mx
 * @since 2019/4/28
 */
public class CustomTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("custom-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(resource);
        Custom custom = factory.getBean("custom1", Custom.class);
        System.out.println(custom.toString());
    }
}
