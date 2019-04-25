package com.shyfay.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件传输实体
 *
 * @author mx
 * @since 2019/4/25
 */
public class RegisterEvent extends ApplicationEvent {
    public RegisterEvent(String name){
        super(name);
    }
}
