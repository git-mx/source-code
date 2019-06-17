package com.shyfay.bean.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 本例用于测试Spring的Aware。
 * 在Spring中提供了很多Aware的接口，比如BeanFactoryAware、ApplicationContextAware、ResourceLoaderAware、ServletContextAware等
 * 实现这些Aware接口的bean在被初始化之后，可以得到一些相应的Spring资源，例如实现BeanFactoryAware接口的类的实例在被初始化后，Spring会为其
 * 注入一个BeanFactory实例，而ApplicationContextAware则会注入一个ApplicationContext实例，在改实现类中可以使用诸如BeanFactory实例或者
 * AppliactionContext实例。
 * 而且一般都有一个set方法，Sping在初始化这个类时会自动调用这个set方法来注入对应的spring资源
 * 例如setBeanFactory，setApplicationContext，setResourceLoader等
 * @author mx
 * @since 2019/4/29
 */
public class AwareTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aware-beans.xml");
        TestAware ta = applicationContext.getBean("test", TestAware.class);
        ta.testSay();
    }
}
