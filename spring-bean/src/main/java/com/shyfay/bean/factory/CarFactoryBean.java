package com.shyfay.bean.factory;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean的使用，实例化工厂，
 * FactoryBean是一个接口，一般情况下Spring通过反射机制利用Bean的class属性指定实现类来实例化bean。在某些情况下，
 * 实例化bean的过程特别复杂，如果要按照传统的方式，则需要在配置文件的<bean标签中提供大量的配置信息，这样就会导致配置文件特别臃肿而且很不灵活
 * 这是采用编码的方式来实例化bean可能会比写在配置文件里更恰当。用户可以通过实现org.springframework.bean.factory.FactoryBean接口来
 * 定制实例化bean的逻辑。当配置文件中<bean标签的class属性对用的类实现了org.springframework.bean.factory.FactoryBean接口时，
 * 通过getBean方法返回的不是FactoryBean本身，而是FactoryBean#getObject方法所返回的对象，相当于FactoryBean#getObject()代理了getBean()
 * 方法，
 *
 * @author mx
 * @since 2019/4/29
 */
@Data
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setId(Integer.valueOf(infos[0]));
        car.setName(infos[1]);
        car.setPrice(Integer.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
