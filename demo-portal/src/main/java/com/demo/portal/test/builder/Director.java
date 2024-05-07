package com.demo.portal.test.builder;

public class Director {

    private BikeBuilder builder;

    public Director(BikeBuilder builder){
        this.builder = builder;
    }

    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}
