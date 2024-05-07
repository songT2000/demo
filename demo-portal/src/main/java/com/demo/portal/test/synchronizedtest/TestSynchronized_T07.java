package com.demo.portal.test.synchronizedtest;

public class TestSynchronized_T07 extends Thread {

    public boolean flag;

    public TestSynchronized_T07(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (this.flag) {
            synchronized (LockObject.lock1) {
                System.out.println("lock1");
                synchronized (LockObject.lock2) {
                    System.out.println("lock2");
                }
            }
        } else {
            synchronized (LockObject.lock2) {
                System.out.println("lock2");
                synchronized (LockObject.lock1) {
                    System.out.println("lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        TestSynchronized_T07 t01 = new TestSynchronized_T07(true);
        TestSynchronized_T07 t02 = new TestSynchronized_T07(false);
        t01.start();
        t02.start();
    }

}
