package com.shyfay.springevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 用户注册服务，事件发布者
 * 在Spring中只要尾部是Aware的Spring定义的接口或类，都是自带注入功能的，
 * 例如这里的ApplicationEventPublisherAware，RegisterService实现了该类，那么Spring会在注册bean时
 * 通过setter方法自动为RegisterService这个bean注入一个ApplicationEventPublisher实例，在自定义的
 * RegisterService类中就可以使用这个实例了。另外的例如BeanFactoryAware，ApplicationContextAware等等
 * 都是类似的功能。
 * @author mx
 * @since 2019/4/25
 */
@Service
public class RegisterService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String name){
        System.out.println("start regist...");
        applicationEventPublisher.publishEvent(new RegisterEvent(name));
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
