package com.demo.portal.test.synchronizedtest;


import java.util.concurrent.TimeUnit;

/**
 * 同步方法：谁先拿到锁谁先执行，同意吧锁顺序执行
 * 普通同步方法锁是 this，当前对象（方法的调用者）
 * 不同对象 不同的this  不同的锁对象
 */
public class TestLock_T06 {


    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone1.sendSMS();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            phone2.call();
        }, "B").start();

    }
}
