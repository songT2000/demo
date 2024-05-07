package com.demo.portal.test.mediator;

/**
 * 抽象同事类
 */
public abstract class Colleague {

    private String name;

    private Mediator mediator;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //接受消息
    public abstract void receive(Colleague colleague, String msg);

    //发送消息
    public abstract void send(Colleague colleague, String msg);

}
