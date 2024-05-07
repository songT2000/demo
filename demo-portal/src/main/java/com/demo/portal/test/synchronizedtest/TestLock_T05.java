package com.demo.portal.test.synchronizedtest;


import java.util.concurrent.TimeUnit;

/**
 * 同步方法，谁先拿到锁谁先执行，同一把锁顺序执行
 * 普通同步方法锁的是 this 当前对象（即方法的调用者）。
 * synchronized实现同步的基础：Java中的每一个对象都可以作为锁。
 * 对于普通同步方法，锁是当前实例对象。
 */
public class TestLock_T05 {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSMS();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            phone.call();
        }, "B").start();

    }
}
