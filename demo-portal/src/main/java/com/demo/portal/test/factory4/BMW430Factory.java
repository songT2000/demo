package com.demo.portal.test.factory4;

public class BMW430Factory implements AbstractBMWFactory{
    @Override
    public BMW creatBMW() {
        System.out.println("BMW430 工厂生产 BMW430");
        return new BMW430();
    }
}
