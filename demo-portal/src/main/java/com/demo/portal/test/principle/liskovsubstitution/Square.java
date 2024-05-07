package com.demo.portal.test.principle.liskovsubstitution;

/**
 * 正方形
 */
public class Square extends Rectangle{

    @Override
    public void setWide(int wide) {
        this.wide = wide;
        this.high = wide;
    }

    @Override
    public void setHigh(int high) {
        this.high = high;
        this.wide = high;
    }

}
