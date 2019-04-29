package com.shyfay.bean.circledependence;

import lombok.Data;

/**
 * @author mx
 * @since 2019/4/29
 */
@Data
public class ClassA {
    private ClassB classB;
    ClassA(ClassB classB){
        this.classB = classB;
    }
}
