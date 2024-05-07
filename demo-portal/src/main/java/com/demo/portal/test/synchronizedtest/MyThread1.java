package com.demo.portal.test.synchronizedtest;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("MyThread1.call()");
        TimeUnit.SECONDS.sleep(5);
        return "MyThread1";
    }
}
