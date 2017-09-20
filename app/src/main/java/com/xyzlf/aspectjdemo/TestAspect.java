package com.xyzlf.aspectjdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhanglifeng on 2017/9/20.
 */

@Aspect
public class TestAspect {

    public static final String TAG = "TestAspect";

    //@After，表示使用After类型的advice，里面的value其实就是一个poincut
    @After(value = "staticinitialization(*..People)")
    public void afterStaticInitial(){
        Log.d(TAG,"the static block is initial");
    }

    @Pointcut(value = "handler(Exception)")
    public void handleException(){

    }

    @Pointcut(value = "within(*..MainActivity)")
    public void codeInMain(){

    }

    // 这里通过&&操作符，将两个Pointcut进行了组合
    // 表达的意思其实就是：在MainActivity当中的catch代码块

    @Before(value = "codeInMain() && handleException()")
    public void catchException(JoinPoint joinPoint){
        Log.d(TAG,"this is a try catch block. " + joinPoint.toString());
    }

}
