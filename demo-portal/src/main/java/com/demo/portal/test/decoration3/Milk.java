package com.demo.portal.test.decoration3;

/**
 * 具体装饰角色
 */
public class Milk extends Decorator {


    public Milk(Drink drink) {
        super(drink);
        super.setDescription("加Milk");
        super.setPrice(2.1f);
    }


}
