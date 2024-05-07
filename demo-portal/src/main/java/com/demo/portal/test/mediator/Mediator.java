package com.demo.portal.test.mediator;

/**
 * 抽象中介类
 */
public abstract class Mediator {

    //注册同事
    public abstract void register(Colleague colleague);

    //转发
    public abstract void relay(Colleague colleague, String msg);
}
