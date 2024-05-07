package com.demo.portal.test.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BuyHouseInvocationHandler implements InvocationHandler {

    public Object target;

    public BuyHouseInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("买房子前");
        Object invoke = method.invoke(target, args);
        System.out.println("买房子后");
        return null;
    }
}
