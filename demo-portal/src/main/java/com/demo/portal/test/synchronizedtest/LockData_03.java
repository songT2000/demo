package com.demo.portal.test.synchronizedtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockData_03 {

    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();//线程等待
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "线程执行增量。num =》" + num);
            condition.signalAll();//唤醒全部线程
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();//线程等待
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "线程执行减量。num =》" + num);
            condition.signalAll();//唤醒全部线程
        }finally {
            lock.unlock();
        }
    }

}
