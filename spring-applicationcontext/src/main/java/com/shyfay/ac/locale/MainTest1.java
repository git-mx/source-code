package com.shyfay.ac.locale;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * java.util.Locale 的使用
 *
 * @author mx
 * @since 2019/4/30
 */
public class MainTest1 {
    //带有语言和国家/地区信息的本地化对象
    Locale locale1 = new Locale("zh", "CN");
    //只有语言信息的本地化对象
    Locale locale2 = new Locale("zh");
    //相当于locale1
    Locale locale3 = Locale.CHINA;
    //相当于locale2
    Locale locale4 = Locale.CHINESE;
    //获取服务器本机的默认本地化对象
    Locale locale5 = Locale.getDefault();

    public static void main(String[] args) {
        String pattern1 = "{0}，你好，你于{1}在工商银行存入{2}元。";
        String pattern2 = "At {1,time,short} On {1, date, long} {0} paid {2, number, currency}.";
        Object[] params = {"Toni", new GregorianCalendar().getTime(), 1.0E3};
        //使用默认的本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg1);
        System.out.println(msg2);
    }
}
