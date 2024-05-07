package com.demo.portal.test.proxy4;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Repository
public class CardDaoImpl implements CardDao {

    @Override
    public int save() {
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/eladmin_number2?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false", "root", "123qwe");
            Statement statement= connection.createStatement();
            String sql="insert into card values (7,'trest')";
            count = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
