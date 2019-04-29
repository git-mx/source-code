package com.shyfay.ac.processor2;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mx
 * @since 2019/4/29
 */
@Data
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private Set<String> obscenties;
    MyBeanFactoryPostProcessor(){
        this.obscenties = new HashSet<String>();
    }
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for(String beanName:beanNames){
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                public String resolveStringValue(String s) {
                    if(isObscene(s)) return "****";
                    return s;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(beanDefinition);
        }
    }

    public boolean isObscene(String source){
        return this.obscenties.contains(source.toUpperCase());
    }
}
