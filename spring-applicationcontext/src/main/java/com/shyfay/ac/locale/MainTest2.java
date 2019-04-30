package com.shyfay.ac.locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 本例用于掩饰ApplicationContext对国家化组件的封装
 * 本例使用到了messages_en_US.properties和messages_zh_CN.properties两个配置文件，
 * 这两个配置文件的命名必须按照这个来命名
 * 另外locale.xml配置中的org.springframework.context.support.ResourceBundleMessageSource这个配置的
 * id必须是messageSource
 * list的值messages就是messages_en_US.properties和messages_zh_CN.properties的前半部分"messages"
 * @author mx
 * @since 2019/4/30
 */
public class MainTest2 {
    public static void main(String[] args) {
        String[] configLocations = {"locale.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
        Object[] params = {"John", new GregorianCalendar().getTime()};
        String str1 = ctx.getMessage("test", params, Locale.US);
        String str2 = ctx.getMessage("test", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }
}
