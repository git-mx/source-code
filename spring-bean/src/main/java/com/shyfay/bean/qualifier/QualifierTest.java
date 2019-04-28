package com.shyfay.bean.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author mx
 * @since 2019/4/28
 */
@Component
public class QualifierTest {
    private Fruit apple;
    private Fruit bananer;

    public Fruit getApple() {
        return apple;
    }

    @Autowired
    public void setApple(@Qualifier("apple") Fruit apple) {
        this.apple = apple;
    }

    public Fruit getBananer() {
        return bananer;
    }

    @Autowired
    @Qualifier("bananer")
    public void setBananer(Fruit bananer) {
        this.bananer = bananer;
    }
}
