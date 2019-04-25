package com.shyfay.springevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 用户注册服务，事件发布者
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
