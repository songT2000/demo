package com.demo.portal.test.principle.liskovsubstitution;

/**
 * 长方形
 */
public class Rectangle {

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
