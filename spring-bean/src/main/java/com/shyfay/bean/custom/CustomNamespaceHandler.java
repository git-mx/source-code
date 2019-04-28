package com.shyfay.bean.custom;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义标签
 *
 * @author mx
 * @since 2019/4/28
 */
public class CustomNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("custom", new CustomBeanDefinitionParse());
    }
}
