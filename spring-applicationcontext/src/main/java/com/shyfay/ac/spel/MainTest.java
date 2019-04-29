package com.shyfay.ac.spel;

import com.shyfay.ac.Root;
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
 * 本实例用于验证ApplicationContext对SpEL语言的支持，
 * 如果使用BeanFactory来获取bean的话，使用${...}这种方式是无法注入属性的
 * 之所以用ApplicationContext可以，是因为ApplicationContext增加了对SpEL语言的支持。
 * @author mx
 * @since 2019/4/29
 */
public class MainTest {
    public static void main(String[] args) {
//        Resource resource = new ClassPathResource("spel.xml");
//        BeanFactory factory = new DefaultListableBeanFactory();
//        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
//        reader.loadBeanDefinitions(resource);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spel.xml");
        Root root = applicationContext.getBean("root", Root.class);
        root.say();
    }
}
