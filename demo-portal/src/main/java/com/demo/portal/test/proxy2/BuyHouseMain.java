package com.demo.portal.test.proxy2;

import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BuyHouseMain {

    public static void main(String[] args) {
        //静态代理
        BuyHouse buyHouse = new BuyHouseProxy(new BuyHouseImpl());
        buyHouse.buyHouse();

        //动态代理
        BuyHouseInvocationHandler buyHouseInvocationHandler = new BuyHouseInvocationHandler(new BuyHouseImpl());
        buyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouseImpl.class.getClassLoader(), BuyHouseImpl.class.getInterfaces(), buyHouseInvocationHandler);
        buyHouse.buyHouse();
    }

    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("买房前准备");

        Object result = methodProxy.invoke(object, args);

        System.out.println("买房后装修");

        return result;

    }
}
