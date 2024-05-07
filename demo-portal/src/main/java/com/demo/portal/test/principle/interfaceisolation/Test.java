package com.demo.portal.test.principle.interfaceisolation;

public class Test {
    public static void main(String[] args) {
        Human blackHuman = new BlackHuman();
        Human whiteHuman = new WhiteHuman();
        Fruits apple = new Apple();
        Fruits banana = new Banana();
        whiteHuman.eatFruits(apple);
        blackHuman.eatFruits(banana);
    }
}
