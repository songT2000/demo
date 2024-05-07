package com.demo.portal.test.factory5;

public class BWM320AirConditioner extends AirConditioner{

    public BWM320AirConditioner(){
        System.out.println("生产 BWM320 空调");
        this.type = "BWM320 空调";
    }
    @Override
    String getType() {
        return type;
    }
}
