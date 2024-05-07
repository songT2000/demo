package com.demo.portal.test.principle.interfaceisolation;

public class Apple extends Fruits{

    public Apple(){
        this.setName("苹果");
        this.setTaste("酸甜");
    }

    @Override
    public void taste() {
        System.out.println(this.getTaste());
    }
}
