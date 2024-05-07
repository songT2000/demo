package com.demo.portal.test.synchronizedtest;

public class TestSynchronized_T06 implements Runnable {
    private static int count = 100;
    private int i = 0;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            if (i % 2 == 0) {
//                synchronized (this) {// 同步方法的锁对象是this，静态同步方法的锁对象是：这个静态同步方法所属的类的字节码文件
                synchronized (TestSynchronized_T06.class) {
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

    public static synchronized void addCount() {
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
        TestSynchronized_T06 t06 = new TestSynchronized_T06();
        Thread t1 = new Thread(t06, "窗口一");
        Thread t2 = new Thread(t06, "窗口二");
        Thread t3 = new Thread(t06, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }

}
