package com.shyfay.bean.autowired;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * file1的bean没有指定autowired属性，需要通过property手动指定teacher和sudent属性
 * file2、file3、file4都指定了autowired，Spring会为其自动装配了在同一个xml配置的bean
 * 如果在配置文件中没有配置对应的teacher和student，则会抛出NullPointerException
 * @author mx
 * @since 2019/4/26
 */
public class AutowiredTest {
    public static void main(String[] args){
        //BeanFactory bf = new XmlBeanFactory()
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(resource);
        TeachFile file1 = (TeachFile)factory.getBean("teachFile1");
        TeachFile file2 = (TeachFile)factory.getBean("teachFile2");
        TeachFile file3 = (TeachFile)factory.getBean("teachFile3");
        TeachFile file4 = (TeachFile)factory.getBean("teachFile4");
        System.out.println("默认情况下，通过'ref’来装配bean");
        file1.print();
        System.out.println("根据byName自动装配bean");
        file2.print();
        System.out.println("根据byType自动装配bean");
        file3.print();
        System.out.println("根据constructor自动装配bean");
        file4.print();
    }
}
