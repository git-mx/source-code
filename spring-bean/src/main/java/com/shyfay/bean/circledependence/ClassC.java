package com.shyfay.bean.circledependence;

import lombok.Data;

/**
 * @author mx
 * @since 2019/4/29
 */
@Data
public class ClassC {
    private ClassA classA;
    ClassC(ClassA classA){
        this.classA = classA;
    }
}
