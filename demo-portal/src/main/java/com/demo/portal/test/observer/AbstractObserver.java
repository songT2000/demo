package com.demo.portal.test.observer;

/**
 * 抽象观察者
 */
public abstract class AbstractObserver {


    //接收到被观察者通知后DoSomething
    abstract void doSomething(String message);


}
