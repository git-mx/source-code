package com.shyfay.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例bean工厂
 * @author mx
 * @since 2019/4/28
 */
public class CarInstanceFactory {
    private Map<Integer, Car> beanContainer = new HashMap<Integer, Car>();

    //这个方法是Getter方法，一定要这样写，否则在xml文件里是无法识别属性beanContainer的。
    public void setBeanContainer(Map<Integer, Car> instances){
        this.beanContainer = instances;
    }

    public CarInstanceFactory(){

    }

    public Car getCar(int id){
        return this.beanContainer.get(id);
    }
}
