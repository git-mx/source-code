package com.shyfay.bean.factory;

import lombok.Data;

/**
 * 业务相关的bean
 * @author mx
 * @since 2019/4/28
 */
@Data
public class Car {
    private int id;
    private String name;
    private int price;

    Car(){}

    Car(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
