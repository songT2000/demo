package com.demo.portal.test.synchronizedtest;


import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest2 {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 插入元素
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // 获取元素
        System.out.println("Value for 'one': " + map.get("one"));

        // 更新元素
        map.put("one", 10);
        System.out.println("Updated value for 'one': " + map.get("one"));

        // 遍历元素
        map.forEach((key, value) -> System.out.println(key + ": " + value));

    }

}
