package com.demo.portal.test.factory4;

public class BMW430 extends BMW{

    public BMW430(){
        this.type = "BMW430";
        System.out.println("生产 BMW430");
    }
    @Override
    String getType() {
        return type;
    }
}
