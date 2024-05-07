package com.demo.portal.test.factory4;

public class BMW320 extends BMW{

    public BMW320(){
        this.type = "BMW320";
        System.out.println("生产 BMW320");
    }
    @Override
    String getType() {
        return type;
    }
}
