package com.demo.portal.test.principle.liskovsubstitution2;

/**
 * 长方形
 */
public class Rectangle implements Quadrangle {

    protected int wide;
    protected int high;

    public int getWide() {
        return wide;
    }

    public void setWide(int wide) {
        this.wide = wide;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "wide=" + wide +
                ", high=" + high +
                '}';
    }
}
