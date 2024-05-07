package com.demo.portal.test.factory4;

public class BMW320Factory implements AbstractBMWFactory{
    @Override
    public BMW creatBMW() {
        System.out.println("BMW320 工厂生产 BMW320");
        return new BMW320();
    }
}
