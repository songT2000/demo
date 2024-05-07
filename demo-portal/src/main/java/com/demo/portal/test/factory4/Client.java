package com.demo.portal.test.factory4;

public class Client {

    public static void main(String[] args) {
        BMW320Factory bmw320Factory = new BMW320Factory();
        BMW bmw = bmw320Factory.creatBMW();
        System.out.println(bmw.getType());
    }
}
