package com.demo.portal.test.synchronizedtest;


public class TestLock_T04 {

    public static void main(String[] args) {
        LockData_04 lockData = new LockData_04();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.runA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.runB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lockData.runC();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

    }
}
