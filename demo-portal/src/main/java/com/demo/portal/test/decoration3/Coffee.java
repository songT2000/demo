package com.demo.portal.test.decoration3;

/**
 * 具体构件
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
