package com.djts.hosu.sample;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTests {

    @Test
    public void testConnection() throws Exception{

        //DB Driver Class
        Class.forName("org.mariadb.jdbc.Driver");

        //URL
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/springdb"
                ,"thoreausawyer"
                ,"daegumian");
        System.out.println("JDBC 연결 확인");
        System.out.println(connection);
        System.out.println("JDBC 연결 확인");
        //username/password

        // close작업 항상 해주기
        connection.close();

        // 여기에서 직접 연결해서 사용해도 되지만, intelliJ에서는 extention같은 기능이 있어서 편하게 가능
    }
}
