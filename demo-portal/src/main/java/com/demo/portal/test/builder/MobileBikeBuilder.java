package com.demo.portal.test.builder;

/**
 * 具体建造者
 */
public class MobileBikeBuilder extends BikeBuilder {
    @Override
    public void buildFrame() {
        bike.setFrame("普通结构车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("软塑料车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }

}
