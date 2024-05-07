package com.demo.portal.test.principle.liskovsubstitution;

public class TransRectangle {

    public static void transRectangle(Rectangle rectangle) {
        while (rectangle.getWide() <= rectangle.getHigh()) {
            rectangle.setWide(rectangle.getHigh() + 1);
        }
    }
}
