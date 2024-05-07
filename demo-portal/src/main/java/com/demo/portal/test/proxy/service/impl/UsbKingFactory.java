package com.demo.portal.test.proxy.service.impl;

import com.demo.portal.test.proxy.service.UsbSell;

public class UsbKingFactory implements UsbSell {


    @Override
    public float sell(int amount) {
        System.out.println("执行UsbKingFactory的sell方法");
        return amount * 85.0f;
    }
}
