package com.shyfay.ac.processor1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 本例用于测试BeanPostProcessor
 * BeanPostProcessor的postProcessBeforeInitialization方法和postProcessAfterInitialization方法
 * 分别是在初始化方法执行的前后执行，我们可以进行一些拦截处理，很多基于SpringMVC实现的MySql的读写分离框架就用到了这个属性
 * 任何实现了BeanPostProcessor接口的类，只要注册到IOC容器中之后，即使没有任何地方使用该类（即方法调用），
 * 该类的postProcessBeforeInitialization
 * 方法和postProcessAfterInitialization方法都会被Spring在加载bean的时候执行
 * @author mx
 * @since 2019/4/29
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("processor1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());
    }
}
