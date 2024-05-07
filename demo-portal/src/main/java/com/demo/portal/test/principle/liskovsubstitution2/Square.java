package com.demo.portal.test.principle.liskovsubstitution2;

/**
 * 正方形
 */
public class Square implements Quadrangle {

    private int wide;
    private int high;

    public void setWide(int wide) {
        this.wide = wide;
        this.high = wide;
    }

    public void setHigh(int high) {
        this.high = high;
        this.wide = high;
    }

    public int getWide() {
        return wide;
    }

    public int getHigh() {
        return high;
    }

    @Override
    public String toString() {
        return "Square{" +
                "wide=" + wide +
                ", high=" + high +
                '}';
    }
}
