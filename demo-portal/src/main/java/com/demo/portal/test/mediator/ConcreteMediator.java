package com.demo.portal.test.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator {

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void relay(Colleague receiver, Colleague sender, String msg) {
        for (Colleague colleague1 : colleagues) {
            if (colleague1.getName().equals(receiver.getName())) {
                colleague1.receive(receiver,sender, msg);
            }
        }
    }
}
