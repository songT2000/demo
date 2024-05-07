package com.demo.portal.test.principle.liskovsubstitution2;

public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWide(3);
        rectangle.setHigh(5);
        System.out.println(rectangle.toString());
        TransRectangle.transRectangle(rectangle);
        System.out.println(rectangle.toString());
        Square square = new Square();
        square.setWide(10);
        System.out.println(square.toString());
        TransRectangle.transSquare(square);
        System.out.println(square);
    }

}
