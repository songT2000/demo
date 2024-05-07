package com.demo.portal.test.factory5;

public class BWM430Factory implements AbstractBMW5Factory{
    @Override
    public Engine createEngine() {
        System.out.println("BWM430Factory 生产 BWM430Engine");
        return new BWM430Engine();
    }

    @Override
    public AirConditioner createAirConditioner() {
        System.out.println("BWM430Factory 生产 BWM430AirConditioner");
        return new BWM430AirConditioner();
    }
}
