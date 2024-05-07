package com.demo.portal.test.adapter;

/**
 * 适配者类
 */
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        return "TFCard read msg ： I am TFcard";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg :" + msg);
    }
}
