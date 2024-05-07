package com.demo.portal.test.testlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        Driver.test();
    }

    static void test() throws InterruptedException {

        int N = 100;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

//        doSomethingElse();// don't let run yet
        System.out.println("don't let run yet");
//        Thread.sleep(1000);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startSignal.countDown();      // let all threads proceed
//        doSomethingElse();
//        Thread.sleep(1000);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doneSignal.await();           // wait for all to finish
    }
}
