package com.shyfay.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author mx
 * @since 2019/5/13
 */
public class MethodInterceptorImpl implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("Before Invoke " + method);
        Object result = methodProxy.invokeSuper(o, objects);
        System.err.println("After Invoke " + method);
        return result;
    }
}
