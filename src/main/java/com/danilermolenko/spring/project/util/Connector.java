package com.danilermolenko.spring.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private final String URL = "jdbc:mysql://localhost:3306/test";
    private final String USERNAME = "bestuser";
    private final String PASSWORD = "bestuser";
    private Connection connection;
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
