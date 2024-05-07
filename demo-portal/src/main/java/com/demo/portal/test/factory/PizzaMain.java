package com.demo.portal.test.factory;

public class PizzaMain {
    public static void main(String[] args) {
        PizzaOrderFactory factory = new PizzaOrderFactory();
        Pizza greek = factory.createPizza("greek");
        System.out.println(greek);
    }
}
