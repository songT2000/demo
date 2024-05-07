package com.demo.portal.test.principle.compositereuse2;

public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(OracleDbConnection.getInstance());

        productDao.addProduct();
    }
}
