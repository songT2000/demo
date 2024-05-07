package com.demo.portal.test.principle.interfaceisolation;

public class Banana extends Fruits {

    public Banana() {
        this.setName("香蕉");
        this.setTaste("软糯香甜");
    }

    @Override
    public void taste() {
        System.out.println(this.getTaste());
    }
}
