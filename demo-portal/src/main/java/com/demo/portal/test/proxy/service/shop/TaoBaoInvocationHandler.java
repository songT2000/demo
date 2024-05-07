package com.demo.portal.test.proxy.service.shop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TaoBaoInvocationHandler implements InvocationHandler {

    public Object target = null;

    public TaoBaoInvocationHandler(Object target) {
        System.out.println("执行 TaoBaoInvocationHandler 的 构造 方法");
        this.target = target;
    }
    //代理对象要执行的功能代码
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行 TaoBaoInvocationHandler 的 invoke 方法");
        //调用目标方法 执行sell
        Object invoke = method.invoke(target, args);
        System.out.println("淘宝销售，满减活动 减5");
        if(invoke != null){
            float price = (float) invoke;
            price = price - 5;
            return price;
        }
        return null;
    }
}
