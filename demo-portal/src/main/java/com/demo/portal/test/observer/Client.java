package com.demo.portal.test.observer;

public class Client {
    public static void main(String[] args) {
        WechatSubject wechatSubject = new WechatSubject();
        wechatSubject.addObserver(new User("张三"));
        wechatSubject.addObserver(new User("李四"));
        wechatSubject.addObserver(new User("王五"));
        wechatSubject.setMessage("有新货");
    }
}
