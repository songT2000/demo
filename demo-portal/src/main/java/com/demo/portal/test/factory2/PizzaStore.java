package com.demo.portal.test.factory2;

import com.demo.portal.test.factory.Pizza;

public class PizzaStore {
    public static void main(String[] args) {

        NYOrderPizza nyOrderPizza = new NYOrderPizza();
        Pizza cheese = nyOrderPizza.createPizza("cheese");


    }
}
