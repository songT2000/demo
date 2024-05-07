package com.demo.portal.test.principle.liskovsubstitution;

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
        TransRectangle.transRectangle(square);//不符合里氏替换原则 陷入死循环
        System.out.println(square);
    }

}
