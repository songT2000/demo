package com.demo.portal.test.synchronizedtest;


public class TestLock_T02 {

    public static void main(String[] args) throws InterruptedException {
//        LockData lockData = new LockData(); //if
        LockData_02 lockData = new LockData_02(); //while

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
