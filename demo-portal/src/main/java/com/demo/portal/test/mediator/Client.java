package com.demo.portal.test.mediator;

public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague = new ConcreteColleague(mediator, "张三");
        Colleague colleague1 = new ConcreteColleague(mediator, "李四");
        Colleague colleague2 = new ConcreteColleague(mediator, "王五");
        Colleague colleague3 = new ConcreteColleague(mediator, "赵大");
        Colleague colleague4 = new ConcreteColleague2(mediator, "tom");
        Colleague colleague5 = new ConcreteColleague2(mediator, "Jerry");
        mediator.register(colleague);
        mediator.register(colleague1);
        mediator.register(colleague2);
        mediator.register(colleague3);
        mediator.register(colleague4);
        mediator.register(colleague5);

        colleague.send(colleague5, "你好");
    }
}
