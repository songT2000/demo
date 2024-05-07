package com.demo.portal.test.principle.compositereuse;

public class OracleDbConnection {

    public OracleDbConnection getOracleDbConnection(){
        System.out.println("获取Oracle数据库连接");
        return new OracleDbConnection();
    }
}
