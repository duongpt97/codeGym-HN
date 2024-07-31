package com.example.shopapp.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasesConnect {
//    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false";
    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456@Abc";
//    private static final String PASSWORD = "";

    public DatabasesConnect() {
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conect databases successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
