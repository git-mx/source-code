package com.shyfay.bean.lookup;

import org.springframework.beans.factory.BeanFactory;
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
public class LookupTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("lookup1-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(resource);
        System.out.println(factory.getBean("fruitPlate1", FruitPlate.class).getFruit());
    }
}
