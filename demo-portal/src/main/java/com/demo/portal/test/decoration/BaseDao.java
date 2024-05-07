package com.demo.portal.test.decoration;

public interface BaseDao<T> {

    int add(T element);
    int delete(T element);
    int update(T element);
    T get(T element);
}