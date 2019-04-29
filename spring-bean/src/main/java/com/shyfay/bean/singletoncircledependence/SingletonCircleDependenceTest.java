package com.shyfay.bean.singletoncircledependence;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 书上说单例模式的，使用循环引用是没有问题的，不过我们的实测结果如下：
 * singleton作用域的bean在创建时，允许设置factory的setAllowCircularReferences = true来开启循环应用
 * 不过开启之后，会报StackOverflowError内存溢出错误。
 * 这里来说明一下classA、classB、classC的创建过程
 * A> Spring 容器创建单例“classA” bean，首先根据元参构造器创建bean，并暴露一个
 *    0bjectFactory用于返回一个提前暴露一个创建中的bean，并将classA标识符放到“当前创建池”， 然后进行setter注入“classB”
 * B> Spring 容器创建单例classB，首先根据无参构造器创建bean，并暴露一个
 *    ObjectFactory用于返回一个提前暴露一个创建中的bean，并将“testB”标识符放到“当前创建池”，然后进行setter注入“classC”
 * C> Spring 容器创建单例classC，首先根据元参构造器创建bean，并暴露一个
 *    ObjectFactory用于返回一个提前暴露一个创建中的bean，并将“testC”标识符放到“当前创建池”，然后进行setter注入“classA”。
 *    进行注入“testA”时由于提前暴露了“0bjectFactory”工厂，从而使用它返回提前暴露一个创建中的bean。
 * D> 最后在依赖注入“classB”和“classC”，完成setter注入。
 * @author mx
 * @since 2019/4/29
 */
public class SingletonCircleDependenceTest {
    public static void main(String[] args){
        Resource resource = new ClassPathResource("singletoncircledependence-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)factory);
        reader.loadBeanDefinitions(resource);
        ((DefaultListableBeanFactory) factory).setAllowCircularReferences(true);
        ClassA classA = factory.getBean("classA", ClassA.class);
        System.out.println(classA);
    }
}
