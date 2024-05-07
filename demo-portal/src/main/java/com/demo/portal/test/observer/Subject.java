package com.demo.portal.test.observer;


/**
 * 被观察者接口
 */
public interface Subject {

    //添加观察者
    void addObserver(AbstractObserver observer);
    //移除观察者
    void removeObserver(AbstractObserver observer);
    //通知观察者
    void notifyObserver(String message);

}
