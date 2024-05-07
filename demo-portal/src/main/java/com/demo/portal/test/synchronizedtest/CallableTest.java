package com.demo.portal.test.synchronizedtest;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        new Thread(new MyThread()).start();

        //适配类 FutureTask 是Runnable接口的实现类  构造器 FutureTask(Callable<V> callable)
        MyThread1 t1 = new MyThread1();
        FutureTask<String> futureTask = new FutureTask<>(t1);//泛型是线程返回值类型

        /*
          启动两个线程，只会打印一个call()
         */
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        try {
            //获取线程返回值， get()可能会产生阻塞！把他放到最后或者使用异步通信来处理！
            String str = futureTask.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
