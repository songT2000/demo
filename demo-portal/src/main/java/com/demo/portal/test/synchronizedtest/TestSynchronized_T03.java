package com.demo.portal.test.synchronizedtest;

public class TestSynchronized_T03 implements Runnable {
    private int count = 1;
    Object o = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addCount();
        }
    }

    public synchronized void addCount() {
        if (count <= 100) {
            System.out.println(Thread.currentThread().getName() + "正在出售第：" + count);
            count++;
        }
    }

    public static void main(String[] args) {
        TestSynchronized_T03 t03 = new TestSynchronized_T03();
        Thread t1 = new Thread(t03, "窗口一");
        Thread t2 = new Thread(t03, "窗口二");
        Thread t3 = new Thread(t03, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }

}
