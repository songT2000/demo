package com.demo.portal.test.synchronizedtest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock_T01 implements Runnable {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Lock lockF = new ReentrantLock(true);

    @Override
    public void run() {
        while (count <= 100) {
            if (lockF.tryLock()) {
                try {
                    if (count <= 100) {
                        try {
                            Thread.sleep(100);
                            System.out.println(Thread.currentThread().getName() + "正在出售第：" + count);
                            count++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lockF.unlock();
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " lockF.tryLock() = " + lockF.tryLock());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int nano = LocalDateTime.now().getNano();
        Thread[] threads = new Thread[3];
        CountDownLatch latch = new CountDownLatch(threads.length);
        TestLock_T01 lt = new TestLock_T01();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(lt, "窗口" + i);
            latch.countDown();
        }
        Arrays.stream(threads).forEach((t) -> {
            t.start();
        });
        latch.await();
        int after = LocalDateTime.now().getNano();
        System.out.println(after - nano);
    }
}
