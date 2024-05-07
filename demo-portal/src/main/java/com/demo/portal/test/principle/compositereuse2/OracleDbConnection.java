package com.demo.portal.test.principle.compositereuse2;

public class OracleDbConnection implements DBConnection {

    private  static volatile OracleDbConnection oracleDbConnection;

    private OracleDbConnection() {
        System.out.println("新建Oracle数据库连接");
    }


    public static OracleDbConnection getInstance() {
        if (oracleDbConnection == null) {
            synchronized (OracleDbConnection.class){
                if(oracleDbConnection == null){
                    oracleDbConnection = new OracleDbConnection();
                }
            }
        }
        return oracleDbConnection;
    }

//    @Override
//    public DBConnection getInstance() {
//        System.out.println("获取Oracle数据库连接");
//        return new OracleDbConnection();
//    }


}
