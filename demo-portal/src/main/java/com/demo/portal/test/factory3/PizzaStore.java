package com.demo.portal.test.factory3;

import com.demo.portal.test.factory.Pizza;

public class PizzaStore {

    public static void main(String[] args) {
        NYOrderPizzaFactory nyOrderPizzaFactory = new NYOrderPizzaFactory();
        Pizza pepper = nyOrderPizzaFactory.createPizza("pepper");
    }
}
