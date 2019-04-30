package com.shyfay.ac.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
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
