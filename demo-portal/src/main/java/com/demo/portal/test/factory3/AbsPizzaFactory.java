package com.demo.portal.test.factory3;

import com.demo.portal.test.factory.Pizza;

/**
 * 工厂方法模式
 */
public interface AbsPizzaFactory {

    Pizza createPizza(String pizzaTye);
}
