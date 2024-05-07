package com.demo.portal.test.synchronizedtest;

public class TestSynchronized_T05 implements Runnable {
    private int count = 100;
    private int i = 0;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            if (i % 2 == 0) {
//                synchronized (obj) {// 一个线程使用同步方法，另一个线程使用同步代码块，但是不是this锁。这种情况不能实现同步
                synchronized (this) { //一个线程使用同步方法，另一个线程使用同步代码块this锁，可以实现同步
                    if (count > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在出售第：" + count);
                        count--;
                    }
                }
            } else {
                addCount();
            }
            i++;
        }
    }

    public synchronized void addCount() {
        if (count > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出售第：" + count);
            count--;
        }
    }

    public static void main(String[] args) {
        TestSynchronized_T05 t05 = new TestSynchronized_T05();
        Thread t1 = new Thread(t05, "窗口一");
        Thread t2 = new Thread(t05, "窗口二");
        Thread t3 = new Thread(t05, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }

}
