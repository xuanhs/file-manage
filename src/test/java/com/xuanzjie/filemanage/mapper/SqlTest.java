package com.xuanzjie.filemanage.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
public class SqlTest {

    @Test
    public void update(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://47.107.111.6:3306/User?useUnicode=true&characterEncoding=utf-8&useAffectRows=true";
        String user = "root";
        String password = "mysqlmima";
        String sql = "update user set password = 'mima12' where id = 1";
        String sqlAll = "update user set password = 'mima123'";
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            stmt =  conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

            count = stmt.executeUpdate(sqlAll);
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

