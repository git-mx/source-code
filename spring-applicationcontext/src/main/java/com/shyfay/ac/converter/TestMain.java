package com.shyfay.ac.converter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * @author mx
 * @since 2019/4/30
 */
public class TestMain {
    public static void main(String[] args) {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());
        String test = "2019-01-01";
        Date date = conversionService.convert(test, Date.class);
        System.out.println(date);
    }
}
