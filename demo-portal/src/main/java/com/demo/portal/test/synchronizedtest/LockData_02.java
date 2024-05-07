package com.demo.portal.test.synchronizedtest;

public class LockData_02 {

    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "线程执行增量。num =》" + num);
        this.notifyAll();
//        while (num == 0) {
//            this.notifyAll();
//        }
    }

    public synchronized void decrement() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "线程执行减量。num =》" + num);
        this.notifyAll();
//        while (num != 0) {
//            this.notifyAll();
//        }

    }

}
