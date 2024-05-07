package com.demo.portal.test.strategy2;

public class Client {

    public static void main(String[] args) {
        OrderGenerateStrategy instance = OrderContextStrategy.getInstance("1");
        instance.orderGenerate();
        instance = OrderContextStrategy.getInstance("2");
        instance.orderGenerate();

    }
}
