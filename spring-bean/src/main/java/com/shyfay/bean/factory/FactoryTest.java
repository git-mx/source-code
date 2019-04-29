package com.shyfay.bean.factory;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * FactoryBean与BeanFactory以及factory-initdestroy
 *
 * @author mx
 * @since 2019/4/28
 */
public class FactoryTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("factory-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(resource);
        Car benzCar1 = factory.getBean("benzCar1", Car.class);
        Car benzCar2 = factory.getBean("benzCar2", Car.class);
        Car benzCar3 = factory.getBean("benzCar3", Car.class);
        System.out.println("benz1:"+benzCar1.toString());
        System.out.println("benz2:"+benzCar2.toString());
        System.out.println("benz3:"+benzCar3.toString());

    }
}
