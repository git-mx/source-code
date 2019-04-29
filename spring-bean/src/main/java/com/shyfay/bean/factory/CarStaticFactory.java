package com.shyfay.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 *  静态bean工厂，相当于一个BeanFactory，
 *  BeanFactory是最基本的IOC容器，负责生产与管理bean，它为其他具有具体的IOC容器提供最基本的规范，如
 *  DefaultListableBeanFactory、XMLBeanFactory、ApplicationContext等都实现了BeanFactory
 * @author mx
 * @since 2019/4/28
 */
public class CarStaticFactory {
    private static Map<Integer, Car> beanContainer = new HashMap<Integer, Car>();

    static {
        beanContainer.put(1, new Car(1, "Benz", 300));
        beanContainer.put(2, new Car(2, "BMW", 400));
        beanContainer.put(3, new Car(3, "Audo", 500));
    }

    public static Car getCar(int id){
        return beanContainer.get(id);
    }
}
