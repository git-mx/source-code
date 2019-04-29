package com.shyfay.ac.processor2;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 本例用于演示BeanFactoryPostProcessor，本例的实际应用是将不文明用语显示成****
 * BeanFactoryPostProcessor，工厂级别的后置处理器
 * Spring IOC容器允许BeanFactoryPostProcessor在容器实际实例化任何其他bean之前读取配置元数据，并有可能修改它。
 * 可以配置多个BeanFactoryPostProcessor，还可以通过设置order属性来控制BeanFactoryPostProcessor的执行次序
 * （仅当BeanFactoryPostProcessor实现了Ordered接口时才可以配置order属性）。
 * BeanFactoryPostProcessor的作用范围是容器级别的，就是只对那些杂定义它的容器内的bean生效
 * @author mx
 * @since 2019/4/29
 */
public class MainTest {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("processor2.xml");
        ConfigurableListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)factory);
        reader.loadBeanDefinitions(resource);
        BeanFactoryPostProcessor bfpp = factory.getBean("bfpp", MyBeanFactoryPostProcessor.class);
        bfpp.postProcessBeanFactory(factory);
//        System.out.println(factory.getBean(""));
        User1 user1 = factory.getBean("user1", User1.class);
        User2 user2 = factory.getBean("user2", User2.class);
        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }
}
