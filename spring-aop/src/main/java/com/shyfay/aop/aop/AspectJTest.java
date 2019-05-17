//package com.shyfay.aop.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//
///**
// * @author mx
// * @since 2019/5/13
// */
//@Aspect
//public class AspectJTest {
//
//    @Pointcut("execution(* *.test(..))")
//    public void test(){}
//
//    @Before("test()")
//    public void brfore(){
//        System.out.println("before...");
//    }
//
//    @After("test()")
//    public void after(){
//        System.out.println("after...");
//    }
//
//    @Around("test()")
//    public Object around(ProceedingJoinPoint point)
//    {
//        System.out.println("around before...");
//        Object obj = null;
//        try{
//            obj = point.proceed();
//        }catch(Throwable e){
//            e.printStackTrace();
//        }
//        System.out.println("aroung after...");
//        return obj;
//    }
//}
