package com.shyfay.ac;

import lombok.Data;

/**
 * @author mx
 * @since 2019/4/29
 */
@Data
public class Root {
    private String key;
    private String val;
    public void say(){
        System.out.println("------------------key:"
                + this.getKey()
                + ",val:"
                + this.getVal()
                + "------------------"
        );
    }
}
