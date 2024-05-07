package com.demo.portal.test.principle.compositereuse;

public class Test {
    public static void main(String[] args) {
        ProductDao p = new ProductDao();

        p.addProduct();
    }
}
