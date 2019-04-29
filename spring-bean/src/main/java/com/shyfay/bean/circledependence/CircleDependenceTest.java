package com.shyfay.bean.circledependence;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 以下这段代码用于演示bean的循环依赖，ClassA的构造函数需要ClassB，ClassB的构造函数需要ClassC，ClassC的构造函数需要ClassA
 * 这样就导致了依赖循环
 * Spring容器将每一个正在创建的bean的标识符放在一个"当前创建池"中，bean的标识符在bean的创建过程中会一直存在与“当前创建池”内，
 * 当bean创建完成之后，Spring将从“当前创建池”中删除该bean的标识符。如果在创建bean的过程中，发现自己的标识符已经在“当前创建池”里时
 * 就会抛出异常。本例中的执行过程如下：
 * 在创建classA时，去池中找ClassA的标识符，没找到，于是将classA的标识符放入池中，
 * 然后执行构造函数实例化classA，但是在执行classA的构造函数的时候，需要构造函数需要参数classB
 * 这时去IOC容器里找classB，找不到，于是Spring开始创建B，这时去池里找classB的标识符，没找到，于是将classB的标识符放入池中
 * 然后执行构造函数实例化classB，但是在执行classB的构造函数时，发现需要参数ClassC，于是类似的又去创建classC.在实例化ClassC时发现
 * 需要ClassA，由于classA正在创建中，于是去IOC容器里肯定找不到classA，于是去创建classA，发现classA的标识符已经在池中了，于是抛出异常。
 * 单例类的循环依赖可以使用setter依赖来解决循环依赖的问题，见例子singletoncircle。
 *
 * @author mx
 * @since 2019/4/29
 */
public class CircleDependenceTest {
    public static void main(String args[]){
        Resource resource = new ClassPathResource("circledependence-beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)factory);
        reader.loadBeanDefinitions(resource);
        ClassA classA = factory.getBean("classA", ClassA.class);
        System.out.println(classA.toString());
    }

}
