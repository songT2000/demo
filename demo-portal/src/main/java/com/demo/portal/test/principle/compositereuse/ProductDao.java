package com.demo.portal.test.principle.compositereuse;

public class ProductDao extends DbConnection {

    public void addProduct() {
        DbConnection connection = super.getConnection();
        System.out.println("新增产品");
    }
}
