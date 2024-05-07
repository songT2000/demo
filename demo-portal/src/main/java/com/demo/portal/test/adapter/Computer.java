package com.demo.portal.test.adapter;

/**
 * 电脑类读取SD卡
 */
public class Computer {
    public String readSD(SDCard sdCard) {
        if(sdCard == null){
            throw  new NullPointerException("读卡错误，请检查SD卡是否插入");
        }
        return sdCard.readSD();
    }
}
