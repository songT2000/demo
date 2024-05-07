package com.demo.portal.test.synchronizedtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockData_04 {

    private int num = 1;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void runA() {
        lock.lock();
        try {
            while (num != 1) {
                conditionA.await();
            }
            num = 2;//唤醒B
            System.out.println(Thread.currentThread().getName() + "线程执行A。num =》" + num);
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void runB() {
        lock.lock();
        try {
            while (num != 2) {
                conditionB.await();
            }
            num = 3;//唤醒C
            System.out.println(Thread.currentThread().getName() + "线程执行B。num =》" + num);
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void runC() {
        lock.lock();
        try {
            while (num != 3) {
                conditionC.await();
            }
            num = 1;//唤醒A
            System.out.println(Thread.currentThread().getName() + "线程执行C。num =》" + num);
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
