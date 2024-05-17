package com.demo.portal.test.hashmap;

import java.util.HashMap;

public class TestHashMap {

    public static void main(String[] args) {

        HashMap<TestKey, String> stringHashMap = new HashMap<>();
        stringHashMap.put(new TestKey("1"), "张三");
        stringHashMap.put(new TestKey("2"),"lisi");
        stringHashMap.put(new TestKey("3"), "wangwu");
        stringHashMap.put(new TestKey("1"), "zhangsan");

        System.out.println(stringHashMap);
    }
}
