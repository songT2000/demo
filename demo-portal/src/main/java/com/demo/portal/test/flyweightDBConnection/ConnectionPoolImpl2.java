package com.demo.portal.test.flyweightDBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolImpl2 implements ConnectionPool {

    private Connection[] connections;

    private String username;

    private String password;

    private String url;
    private int capacity;

    private Semaphore semaphore;

    public ConnectionPoolImpl2(String username, String password, String url, int capacity) throws SQLException {
        this.capacity = capacity;
        connections = new Connection[capacity];
        for (int i = 0; i < capacity; i++) {
            connections[i] = new ConnectionDecorator(DBUtil.getConnection(url, username, password));
        }
        semaphore = new Semaphore(capacity);
    }

    @Override
    public Connection getConnection() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < connections.length; i++) {
            ConnectionDecorator connection = (ConnectionDecorator) connections[i];
            AtomicInteger state = connection.getState();
            if (state.compareAndSet(0, 1)) {
                return connection;
            }
        }
        return null;
    }

    @Override
    public void giveBlackConnection(Connection connection) {
        for (int i = 0; i < connections.length; i++) {
            if (connection == connections[i]) {
                ConnectionDecorator connectionCast = (ConnectionDecorator) connection;
                AtomicInteger state = connectionCast.getState();
                state.set(0);
                semaphore.release();
                return;
            }
        }
        throw new RuntimeException("此连接不是本线程池中的连接");
    }


}