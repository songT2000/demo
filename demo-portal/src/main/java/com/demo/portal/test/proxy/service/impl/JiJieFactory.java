package com.demo.portal.test.proxy.service.impl;

import com.demo.portal.test.proxy.service.UsbSell;

public class JiJieFactory implements UsbSell {


    @Override
    public float sell(int amount) {
        System.out.println("执行JiJieFactory的sell方法");
        return amount * 55.0f;
    }
}
