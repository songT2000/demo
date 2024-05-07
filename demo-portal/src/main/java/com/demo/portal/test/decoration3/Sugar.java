package com.demo.portal.test.decoration3;

public class Sugar extends Decorator {


    public Sugar(Drink drink) {
        super(drink);
        super.setDescription("加糖");
        super.setPrice(1.1f);
    }


}
