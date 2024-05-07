package com.demo.portal.test.observer;

/**
 * 实体观察者
 */
public class User extends AbstractObserver{

    private String name;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    @Override
    void doSomething(String message) {
        System.out.println(name + " 接收到: " + message);
    }
}
