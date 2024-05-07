package com.demo.portal.test.factory5;

public class BWM430AirConditioner extends AirConditioner{

    public BWM430AirConditioner(){
        System.out.println("生产 BWM430 空调");
        this.type = "BWM430 空调";
    }
    @Override
    String getType() {
        return type;
    }
}
