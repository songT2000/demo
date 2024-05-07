package com.demo.portal.test.principle.interfaceisolation;

public class WhiteHuman implements Human {

    @Override
    public void eatFruits(Fruits fruits) {
        System.out.println("白人在吃：" + fruits.getName() + " 味道：" + fruits.getTaste());
    }

    @Override
    public void sleep() {
        System.out.println("白人在休息");
    }
}
