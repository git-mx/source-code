package com.shyfay.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 积分服务，订阅注册事件
 * @author mx
 * @since 2019/4/25
 */
@Service
public class ScoreService implements ApplicationListener<RegisterEvent> {
    @Override
    public void onApplicationEvent(RegisterEvent registerEvent) {
        System.out.println("init score for the user " + registerEvent.getSource() + "...");
    }
}
