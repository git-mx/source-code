package com.shyfay.ac.customcontext;

import com.shyfay.ac.Root;
import org.springframework.context.ApplicationContext;

/**
 * 该例子用于测试自定义的ApplicationContext。
 * 应用场景是：假设现在我们要建设一个系统，这个系统要求在系统拥有某个环境变量时才启动，如果环境变量不存在则抛出异常
 * 试试把VAR改成JAVA_HOME，就可以启动了
 * @author mx
 * @since 2019/4/29
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new MyApplicationContext("root.xml");
        Root root = context.getBean("root", Root.class);
        root.say();
    }
}
