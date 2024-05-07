package com.demo.portal.test.factory3;

import com.demo.portal.test.factory.Pizza;
import com.demo.portal.test.factory2.LDCheesePizza;
import com.demo.portal.test.factory2.LDPepperPizza;

public class LDOrderPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
