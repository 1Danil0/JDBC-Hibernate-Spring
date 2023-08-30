package com.danilermolenko.spring.test;

import java.sql.*;

public class App2 {
    public static final String URl = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME = "bestuser";
    public static final String PASSWORD = "bestuser";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        Savepoint savepoint = null;
        try{
            connection = DriverManager.getConnection(URl, USERNAME, PASSWORD);
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("insert into users (name, age, email) values (?, ?, ?);");
            preparedStatement.setInt(2, 22);
            preparedStatement.setString(1, "Danil");
            preparedStatement.setString(3, "d@@@");
            preparedStatement.executeUpdate();

            savepoint = connection.setSavepoint();

            preparedStatement = connection.prepareStatement("insert  into users (name, ag) values (?, ?);");
            preparedStatement.setString(1, "Danil2");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();


            connection.commit();
        } catch (SQLException e){
            connection.rollback(savepoint);
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            if(set != null) {
                set.close();
            }
        }
    }
}
