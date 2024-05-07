package com.demo.portal.test.factory5;

public class Client {
    public static void main(String[] args) {
        BWM320Factory bwm320Factory = new BWM320Factory();
        Engine engine = bwm320Factory.createEngine();
        AirConditioner airConditioner = bwm320Factory.createAirConditioner();
        System.out.println(engine.getType());
        System.out.println(airConditioner.getType());
    }
}
