package com.shyfay.bean.replaced;

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
public class ReplaceTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("replaced-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)factory);
        reader.loadBeanDefinitions(resource);
        PlayerOne playerOne = factory.getBean("dennies", PlayerOne.class);
        Player player = playerOne.onPlace();
        System.out.println(player.toString());
    }


}
