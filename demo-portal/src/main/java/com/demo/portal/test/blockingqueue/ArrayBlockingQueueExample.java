package com.demo.portal.test.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个大小为3的ArrayBlockingQueue
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        // 生产者线程向队列中添加元素
        Thread producer = new Thread(() -> {
            try {
                queue.put("A");
                System.out.println("Produced A");
                queue.put("B");
                System.out.println("Produced B");
                queue.put("C");
                System.out.println("Produced C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 消费者线程从队列中获取元素
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000); // 模拟消费者处理时间
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(2000); // 模拟消费者处理时间
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(2000); // 模拟消费者处理时间
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
