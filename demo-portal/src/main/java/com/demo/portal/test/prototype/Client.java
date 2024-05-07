package com.demo.portal.test.prototype;

public class Client {

    public static void main(String[] args) {
        Fridge fridge = new FishFridge();
        fridge.store();
        fridge = new ElephantFridge();
        fridge.store();
    }
}
