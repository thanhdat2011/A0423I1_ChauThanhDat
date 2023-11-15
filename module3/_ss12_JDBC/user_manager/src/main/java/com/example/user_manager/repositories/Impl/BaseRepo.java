package com.example.user_manager.repositories.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/user_manager";
    private static final String username = "root";
    private static final String password = "20112000";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BaseRepo() {
    }

    public static Connection getConnectionJavaToDB() {
        return connection;
    }
}
