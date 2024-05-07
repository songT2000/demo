package com.demo.portal.test.flyweightDBConnection;

import java.sql.Connection;

public interface ConnectionPool {

    //获取链接
    Connection getConnection();

    void giveBlackConnection(Connection connection);

}
