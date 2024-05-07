package com.demo.portal.test.flyweightDBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Client {

    public static void main(String[] args) throws SQLException {
//        ConnectionPoolImpl1 connectionPoolImpl1 = new ConnectionPoolImpl1("root", "123qwe",
//                "jdbc:mysql://localhost:3306/ai?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8",
//                2);
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                try {
//                    Connection connection = connectionPoolImpl1.getConnection();
//                    System.out.println(Thread.currentThread().getName() + "--获取到连接:" + connection);
//                    Thread.sleep(5000);
//                    System.out.println(Thread.currentThread().getName() + "--归还:" + connection);
//                    connectionPoolImpl1.giveBlackConnection(connection);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }, "t" + (i + 1)).start();
//        }


        ConnectionPool connectionPoolImpl2 = new ConnectionPoolImpl2(
                "root",
                "123qwe",
                "jdbc:mysql://localhost:3306/ai?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8",
                2
        );

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "等待连接" );
                    Connection connection = connectionPoolImpl2.getConnection();
                    System.out.println(Thread.currentThread().getName() + "--获取到连接:" + connection);
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "--归还:" + connection);
                    connectionPoolImpl2.giveBlackConnection(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t" + (i + 1)).start();
        }
    }
}
