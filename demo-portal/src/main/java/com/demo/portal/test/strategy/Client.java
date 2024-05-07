package com.demo.portal.test.strategy;

public class Client {

    public static void main(String[] args) {
        Environment environment = new Environment(new AddStrategy());
        System.out.println(environment.calculate(3, 61));
    }
}
