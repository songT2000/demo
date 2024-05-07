package com.demo.portal.test.principle.interfaceisolation;

public class BlackHuman implements Human{

    @Override
    public void eatFruits(Fruits fruits) {
        System.out.println("黑人在吃：" + fruits.getName() + " 味道：" + fruits.getTaste());
    }

    @Override
    public void sleep() {
        System.out.println("黑人在休息");
    }
}
