package com.demo.portal.test.decoration3;

public class Drinker {

    public static void main(String[] args) {
        Drink drink = new DeCoffee();
        System.out.println("本次点单描述：" + drink.getDescription() );
        System.out.println("本次点单描费用：" + drink.cost());
        //需要给DeCoffee添加其他饮品
        drink = new Milk(drink);
        System.out.println("本次点单描述：" + drink.getDescription() );
        System.out.println("本次点单描费用：" + drink.cost());
        drink = new Sugar(drink);
        System.out.println("本次点单描述：" + drink.getDescription() );
        System.out.println("本次点单描费用：" + drink.cost());



    }
}
