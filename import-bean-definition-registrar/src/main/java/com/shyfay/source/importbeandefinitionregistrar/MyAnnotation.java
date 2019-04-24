package com.shyfay.source.importbeandefinitionregistrar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author mx
 * @since 2019/4/24
 */

/**
 * 这是java的元注解，表明MyComponent这个注解应该被 javadoc工具记录
 */
@Documented
/**
 * 这是java的元注解，它表明一个作用于类classA的被@Inherited修饰的注解annotationA，会被继承classA的类classB继承
 * 如果@annotationA没有被@Inherited注解修饰，那么子类classB是不会被注解annotationA作用的。
 */
@Inherited
/**
 * 这是java的元注解，它告诉应用程序，被该注解修饰的注解的生命周期
 * 1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 * 常见的RetentionPolicy.SOURCE注解有@Override和@SuppressWarnings注解，就是源码注解，它们的作用就是在编写源码时
 * 告诉程序员一些问题，比如@Override的方法名不对，参数不对啥的
 * 常见的RetentionPolicy.CLASS注解有不知道
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 这是java的元注解，它表示该注解能作用的对象，比如包、类、方法、参数、字段等等
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Import(MyImportBeanDefinitationRegistrar.class)
public @interface MyAnnotation {
}
