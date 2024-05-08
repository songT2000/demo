package com.demo.portal.test.mediator;

/**
 * 具体同事类
 */
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(Colleague receiver, Colleague sender, String msg) {
        System.out.println("同事[" + this.getName() + "]接收到同事[" + sender.getName() + "]消息" + msg);
    }

    @Override
    public void send(Colleague colleague, String msg) {
        System.out.println("同事[" + this.getName() + "]发送消息" + msg + "到同事[" + colleague.getName() + "]");
        this.getMediator().relay(colleague, this, msg);
    }
}
