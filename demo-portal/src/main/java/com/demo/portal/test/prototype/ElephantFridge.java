package com.demo.portal.test.prototype;

public class ElephantFridge extends Fridge{
    @Override
    void put() {
        System.out.println("将大象放入冰箱");
    }

    @Override
    protected boolean needFreezer() {
        return false;
    }
}
