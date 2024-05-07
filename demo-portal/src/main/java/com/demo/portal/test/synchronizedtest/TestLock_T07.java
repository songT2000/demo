package com.demo.portal.test.synchronizedtest;


import java.util.concurrent.TimeUnit;

/**
 * 静态同步方法锁的是类对象，类只会加载一次，所以静态同步方法永远锁的都是类对象（XXX.class）
 * synchronized实现同步的基础：Java中的每一个对象都可以作为锁。
 * 对于静态同步方法，锁是当前类的Class对象。
 * 类只会加载一次，所以静态同步方法永远锁的都是类对象
 */
public class TestLock_T07 {

    public static void main(String[] args) {
        new Thread(() -> {
            Phone2.sendSMS();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            Phone2.call();
        }, "B").start();

    }
}
