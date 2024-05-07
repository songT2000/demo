package com.demo.portal.test.synchronizedtest;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {

    public static void main(String[] args) {
//        HashSet<String> strings = new HashSet<>();
        // 解决方式一
//        Set<String> strings = Collections.synchronizedSet(new HashSet<>());
        // 解决方式二
        Set<Object> strings = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                strings.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(strings);
            }, String.valueOf(i)).start();
        }


    }

}
