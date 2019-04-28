package com.shyfay.bean.replaced;

/**
 * 原始的类的方法-即要被替换的方法
 * 雷霆队的主控拉塞尔.威斯特布鲁克
 *
 * @author mx
 * @since 2019/4/28
 */
public class PlayerOne {
    public Player onPlace(){
        System.out.println("Russ Westbrook is on the place");
        Player player = new Player();
        player.setId(1);
        player.setName("Russ Westbrook");
        return player;
    }
}
