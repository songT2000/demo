package com.demo.portal.test.synchronizedtest;

public class TestSynchronized_T01 implements Runnable {

    private int count = 1;

    @Override
    public void run() {
        while (true) {
            if (count <= 100) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第：" + count);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        TestSynchronized_T01 t01 = new TestSynchronized_T01();
        Thread t1 = new Thread(t01,"窗口一");
        Thread t2 = new Thread(t01,"窗口二");
        Thread t3 = new Thread(t01,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }


}
