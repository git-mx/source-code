package com.shyfay.ac.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converter是非常有用的，在SpringMVC开发中经常需要使用converter来
 * 将前端传过来的字符串转换成后端需要的对象，或者将后端对象转换成前端需要的JSON对象。
 * @author mx
 * @since 2019/4/30
 */
public class String2DateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd");
            return sdf.parse(s);
        }catch(ParseException e){
            return null;
        }
    }
}
