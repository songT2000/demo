package com.demo.portal.test.principle.compositereuse;

public class DbConnection {

    public DbConnection getConnection(){
        System.out.println("获取数据库连接");
        return new DbConnection();
    }
}
