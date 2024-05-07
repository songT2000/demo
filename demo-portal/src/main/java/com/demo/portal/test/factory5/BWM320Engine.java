package com.demo.portal.test.factory5;

public class BWM320Engine extends Engine{

    public BWM320Engine(){
        System.out.println("生产BWM320引擎");
        this.type = "BWM320引擎";
    }

    @Override
    String getType() {
        return type;
    }
}
