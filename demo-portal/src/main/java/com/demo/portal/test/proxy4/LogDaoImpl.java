package com.demo.portal.test.proxy4;

import org.springframework.stereotype.Repository;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;

@Repository
public class LogDaoImpl implements LogDao {
    @Override
    public int addLog(String name) {
        int count = 0;
        try {
//date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
//ip4
            InetAddress ip4 = Inet4Address.getLocalHost();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eladmin_number2?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false", "root", "123qwe");
            Statement statement = connection.createStatement();
            String sql = "insert into log values (7, '" + date + "','" + ip4.getHostAddress() + "','" + name + "')";
            count = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
