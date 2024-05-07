package com.demo.portal.test.synchronizedtest;


public class TestLock_T03 {

    public static void main(String[] args) throws InterruptedException {
        LockData_03 lockData = new LockData_03();

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
