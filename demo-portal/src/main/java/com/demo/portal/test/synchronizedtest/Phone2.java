package com.demo.portal.test.synchronizedtest;

import java.util.concurrent.TimeUnit;

public class Phone2 {

    public static synchronized void sendSMS(){

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送短信");
    }

    public static synchronized void call(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("打电话");
    }

}
