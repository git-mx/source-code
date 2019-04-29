package com.shyfay.ac.propertyeditor2;

import lombok.Data;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mx
 * @since 2019/4/29
 */
@Data
public class DatePropertyEditor extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";
    public void setAsText(String arg0) throws IllegalArgumentException {
        System.out.println("arg0:" + arg0);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try{
            Date d = sdf.parse(arg0);
            this.setValue(d);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
