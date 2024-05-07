package com.demo.portal.test.builder;

public class OfoBikeBuilder extends BikeBuilder {
    @Override
    public void buildFrame() {
        bike.setFrame("钢结构车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("人造革车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }

}
