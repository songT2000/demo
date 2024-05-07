package com.demo.portal.test.flyweightDBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolImpl1 implements ConnectionPool {

    private Connection[] connections;
    private String username;
    private String password;
    private String url;
    private Integer capacity;

    public ConnectionPoolImpl1(String username, String password, String url, Integer capacity) throws SQLException {
        this.capacity = capacity;
        connections = new Connection[capacity];
        for (int i = 0; i < capacity; i++) {
            connections[i] = new ConnectionDecorator(DBUtil.getConnection(url, username, password));
        }
    }


    @Override
    public Connection getConnection() {
        while (true) {
            for (int i = 0; i < connections.length; i++) {
                ConnectionDecorator connectionDecorator = (ConnectionDecorator) connections[i];
                AtomicInteger state = connectionDecorator.getState();
                if (state.compareAndSet(0, 1)) {
                    return connectionDecorator;
                }
            }
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 线程等待");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void giveBlackConnection(Connection connection) {
        for (int i = 0; i < connections.length; i++) {
            if (connection == connections[i]) {
                ConnectionDecorator connectionDecorator = (ConnectionDecorator) connection;
                AtomicInteger state = connectionDecorator.getState();
                state.set(0);
                //唤醒等待线程
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + "唤醒等待线程");
                    notify();
                }
                return;
            }
        }
        throw new RuntimeException("该链接不是线程池链接");
    }
}
