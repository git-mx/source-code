package com.shyfay.bean.circledependence;

import lombok.Data;

/**
 * @author mx
 * @since 2019/4/29
 */
@Data
public class ClassB {
    private ClassC classC;
    ClassB(ClassC classC){
        this.classC = classC;
    }
}
