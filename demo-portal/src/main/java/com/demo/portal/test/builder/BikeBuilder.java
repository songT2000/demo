package com.demo.portal.test.builder;

/**
 * 抽象建造者
 */
public abstract class BikeBuilder {

    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();

//    public Bike construct(){
//        this.buildFrame();
//        this.buildSeat();
//        return bike;
//    }
}
