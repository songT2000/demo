package com.demo.portal.test.prototype;

public class FishFridge extends Fridge{
    @Override
    void put() {
        System.out.println("将鱼放入冰箱");
    }

    @Override
    protected boolean needFreezer() {
        return true;
    }
}
