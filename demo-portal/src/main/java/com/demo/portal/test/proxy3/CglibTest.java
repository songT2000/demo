package com.demo.portal.test.proxy3;

import com.demo.portal.test.proxy2.BuyHouse;
import com.demo.portal.test.proxy2.BuyHouseImpl;

public class CglibTest {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouse buyHouse = (BuyHouse) cglibProxy.createProxy(new BuyHouseImpl());
        buyHouse.buyHouse();
    }
}
