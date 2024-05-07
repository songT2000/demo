package com.demo.portal.test.factory;

/**
 * 简单工厂模式
 * 优点：将对象的创建交给专门的工厂类负责，实现了对象的创建和对象的使用分离。
 * 缺点： 工厂类不够灵活，增加新的具体产品需要修改工厂类的判断逻辑代码，比如新增一种口味的Pizza，
 * 需要增加一个 if 判断分支才能支持。而且当产品类型较多时，简单工厂的 if 判断将会非常多，不容易维护。
 */
public class PizzaOrderFactory {

    public Pizza createPizza(String pizzaType) {
        if ("cheese".equals(pizzaType)) {
            return new CheesePizza();
        } else if ("greek".equals(pizzaType)) {
            return new GreekPizza();
        } else if ("Pepper".equals(pizzaType)) {
            return new PepperPizza();
        }
        return null;
    }
}
