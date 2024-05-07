package com.demo.portal.test.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体被观察者
 */
public class WechatSubject implements Subject{

    List<AbstractObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AbstractObserver observer) {
        if(!observers.isEmpty()){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String message) {
        if(!observers.isEmpty()){
            observers.stream().forEach(o ->{
                o.doSomething(message);
            });
        }
    }

    public void setMessage(String message){
        System.out.println("微信服务更新消息： " + message);
        notifyObserver(message);
    }
}
