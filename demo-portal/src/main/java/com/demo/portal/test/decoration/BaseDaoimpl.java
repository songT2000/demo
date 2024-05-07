package com.demo.portal.test.decoration;

public class BaseDaoimpl<T> implements BaseDao<T>{
    @Override
    public int add(T element) {
        System.out.println("add method is success");
        return 0;
    }

    @Override
    public int delete(T element) {
        System.out.println("delete method is success");
        return 0;
    }

    @Override
    public int update(T element) {
        System.out.println("update method is success");
        return 0;
    }

    @Override
    public T get(T element) {
        System.out.println("get method is success");
        return element;
    }
}
