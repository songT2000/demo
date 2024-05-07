package com.demo.portal.test.synchronizedtest;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }
}
