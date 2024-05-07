package com.demo.portal.test.factory5;

public class BWM430Engine extends Engine{

    public BWM430Engine(){
        System.out.println("生产 BWM430 引擎");
        this.type = "BWM430 引擎";
    }

    @Override
    String getType() {
        return type;
    }
}
