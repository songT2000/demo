package com.demo.portal.test.proxy3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    //代理方法
    public Object createProxy(Object target){
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //添加回调函数
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //创建切面类对象
        TestAdvice testAdvice = new TestAdvice();
        //前增强
        testAdvice.doSomething();
        //目标方法执行
        Object obj = methodProxy.invokeSuper(proxy, objects);
        //后执行
        testAdvice.doSomething();
        return obj;
    }
}
