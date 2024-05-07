package com.demo.portal.test.factory3;

import com.demo.portal.test.factory.Pizza;
import com.demo.portal.test.factory2.NYCheesePizza;
import com.demo.portal.test.factory2.NYPepperPizza;

public class NYOrderPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new NYPepperPizza();
        }
        return pizza;
    }
}
