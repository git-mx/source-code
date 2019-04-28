package com.shyfay.bean.custom;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 自定义标签
 *
 * @author mx
 * @since 2019/4/28
 */
public class CustomBeanDefinitionParse extends AbstractSingleBeanDefinitionParser {
    protected Class getBeanClass(Element element){
        return Custom.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean){
        String name = element.getAttribute("name");
        String value = element.getAttribute("value");
        if(StringUtils.hasText(name)){
            bean.addPropertyValue("name", name);
        }
        if(StringUtils.hasText(value)){
            bean.addPropertyValue("value", value);
        }
    }
}
