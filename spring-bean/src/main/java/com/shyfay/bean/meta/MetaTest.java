package com.shyfay.bean.meta;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author mx
 * @since 2019/4/28
 */
public class MetaTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("meta-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(resource);
        BeanDefinition beanDefinition = ((DefaultListableBeanFactory)factory).getBeanDefinition("benzCar");
        //不妨在这打个断点看看，beanDefinition有些什么属性
        System.out.println(beanDefinition.getAttribute("attributeKey"));

    }
}
