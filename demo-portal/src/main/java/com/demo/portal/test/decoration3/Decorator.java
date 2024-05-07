package com.demo.portal.test.decoration3;


/**
 * 抽象装饰角色
 */
public class Decorator extends Drink {

    public Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(drink.getDescription() + "-" + description);
    }

}
