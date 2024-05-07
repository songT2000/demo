package com.demo.portal.test.synchronizedtest;

public class LockData {

    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        if (num != 0) {
            System.out.println(Thread.currentThread().getName() + " increment线程等待 num= " + num );
            this.wait();
        } else {
            num++;
            System.out.println(Thread.currentThread().getName() + "线程执行增量。num =》" + num);
            this.notifyAll();
        }
    }

    public synchronized void decrement() throws InterruptedException {
        if (num == 0) {
            System.out.println(Thread.currentThread().getName() + " decrement线程等待 num= " + num );
            this.wait();
        } else {
            num--;
            System.out.println(Thread.currentThread().getName() +  "线程执行减量。num =》" + num);
            this.notifyAll();
        }
    }

}
