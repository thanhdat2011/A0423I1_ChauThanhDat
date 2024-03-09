package com.example.ss9.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/demo_a0423i1";
    private static final String username = "root";
    private static final String password = "28101998";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private BaseRepository() {

    }

    public static Connection getConnectionJavaToDB() {
        return connection;
    }
}
