package com.demo.portal.test.principle.compositereuse2;

public class ProductDao {
    private DBConnection dbConnection;

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        System.out.println("添加产品");
    }
}
