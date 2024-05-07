package com.demo.portal.test.synchronizedtest;


import lombok.extern.log4j.Log4j;

import java.util.concurrent.TimeUnit;

@Log4j
public class TestWait_T01 {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                log.info("获取了锁");
                try {
                    log.info("休眠一会儿");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("调用wait..");
                try {
                    log.info("wait前的线程状态" + Thread.currentThread().getState());
                    lock.wait(1000);
                    log.info("wait后的线程状态" + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("被唤醒");
            }
        }, "A");
        threadA.start();

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Thread threadB = new Thread(() -> {
//            synchronized (lock) {
//                log.info("获得了锁");
//                log.info("叫醒A前，A的状态" + threadA.getState());
//                log.info("叫醒A");
//                lock.notify();
//            }
//        }, "B");
//        threadB.start();
        Thread threadB = new Thread(()->{
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("线程A的状态" + threadA.getState());

//                while (true) {
//
//                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        threadB.start();
    }
}
