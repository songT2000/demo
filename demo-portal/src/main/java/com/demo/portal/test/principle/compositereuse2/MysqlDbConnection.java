package com.demo.portal.test.principle.compositereuse2;

public class MysqlDbConnection implements DBConnection {

    private static MysqlDbConnection mysqlDbConnection;

    private MysqlDbConnection() {
        System.out.println("获取MySQL数据库连接");
    }

    public static MysqlDbConnection getInstance() {
        if (mysqlDbConnection == null) {
            synchronized (MysqlDbConnection.class) {
                mysqlDbConnection = new MysqlDbConnection();
            }
        }
        return mysqlDbConnection;
    }
}
