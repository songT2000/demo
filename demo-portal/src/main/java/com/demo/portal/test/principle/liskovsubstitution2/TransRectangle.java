package com.demo.portal.test.principle.liskovsubstitution2;

public class TransRectangle {

    public static void transRectangle(Rectangle rectangle) {
        while (rectangle.getWide() <= rectangle.getHigh()) {
            rectangle.setWide(rectangle.getHigh() + 1);
        }
    }

    public static void transSquare(Square square) {
        System.out.println("正方形变形");
    }
}
