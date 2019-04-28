package com.shyfay.bean.replaced;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * 目标类方法-即用于替换原始类方法的方法
 * 雷霆队的首席替补控卫丹尼斯.斯罗德
 * @author mx
 * @since 2019/4/28
 */
public class PlayerTwo implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        Player player = new Player();
        player.setId(2);
        player.setName("Dennis Schroeder");
        System.out.println("Dennis Schroeder replaced replace Russ Westbrook just now...");
        return player;
    }
}
