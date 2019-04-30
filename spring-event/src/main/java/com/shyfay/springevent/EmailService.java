package com.shyfay.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 邮件服务，订阅注册事件
 * 在spring的事件机制中，类要具备接收事件的功能，那么该类必须实现ApplicationListener接口
 * 通过重写onApplicationEvent方法来实现自己的业务逻辑
 * @author mx
 * @since 2019/4/25
 */
@Service
public class EmailService implements ApplicationListener<RegisterEvent> {
    @Override
    public void onApplicationEvent(RegisterEvent registerEvent) {
        System.out.println("send email to " + registerEvent.getSource() + "...");
    }
}
