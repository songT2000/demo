package com.demo.portal.test.factory5;

public class BWM320Factory implements AbstractBMW5Factory{
    @Override
    public Engine createEngine() {
        System.out.println("BWM320Factory 生产 BWM320Engine");
        return new BWM320Engine();
    }

    @Override
    public AirConditioner createAirConditioner() {
        System.out.println("BWM320Factory 生产 BWM320AirConditioner");
        return new BWM320AirConditioner();
    }
}
