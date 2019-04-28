package com.shyfay.bean.alias;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author mx
 * @since 2019/4/28
 */
public class AliasTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("alias-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(resource);
        Person person1 = factory.getBean("person2", Person.class);
        System.out.println(person1.toString());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("alias-beans.xml");
        Person person2 = applicationContext.getBean("alias1", Person.class);
        System.out.println(person2.toString());
    }
}
