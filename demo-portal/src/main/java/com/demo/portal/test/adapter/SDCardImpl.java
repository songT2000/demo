package com.demo.portal.test.adapter;

/**
 *  具体的被适配者
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "SDCard read msg ：I am SD";
        return msg;
    }

    @Override
    public void writeSd(String msg) {
        System.out.println("SDCard write msg ：" + msg);
    }
}
