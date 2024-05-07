package com.demo.portal.test.proxy.service;

import com.demo.portal.test.proxy.service.impl.JiJieFactory;
import com.demo.portal.test.proxy.service.impl.UsbKingFactory;
import com.demo.portal.test.proxy.service.shop.TaoBaoInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {

    public static void main(String[] args) {
        /**
         * 实现动态代理的步骤
         * 1.创建接口，定义目标类要完成的功能
         * 2.创建目标类实现接口
         * 3.创建InvocationHandler接口的实现类，在invoke方法中完成代理类的功能
         *  a.调用目标方法
         *  b.增强功能
         * 4.使用Proxy类的静态方法，创建代理对象。并把返回值转为接口类型。
         *
         */
//        ClassLoader classLoader = UsbKingFactory.class.getClassLoader();
        //1创建目标对象
        UsbKingFactory usbKingFactory = new UsbKingFactory();
        JiJieFactory jiJieFactory = new JiJieFactory();
//        float amount =  usbKingFactory.sell(2);
//        System.out.println("厂家直销价：" + amount);
        //2创建InvocationHandler对象
        InvocationHandler invocationHandler = new TaoBaoInvocationHandler(usbKingFactory);
        //3.创建代理对象 （返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。）
        UsbSell usbSell = (UsbSell) Proxy.newProxyInstance(usbKingFactory.getClass().getClassLoader(),
                usbKingFactory.getClass().getInterfaces(),
                invocationHandler);
        InvocationHandler taoBaoInvocationHandler = new TaoBaoInvocationHandler(jiJieFactory);

        UsbSell jiJeUsbSell = (UsbSell)Proxy.newProxyInstance(jiJieFactory.getClass().getClassLoader(),
                jiJieFactory.getClass().getInterfaces(),
                taoBaoInvocationHandler);
        //4.通过代理执行方法
        float price = usbSell.sell(2);
        System.out.println("淘宝销售价：" + price);

        float price1 = jiJeUsbSell.sell(2);
        System.out.println("淘宝季节销售价：" + price1);

    }
}
