package com.danilermolenko.spring.test;

import java.sql.*;

public class IsolationLevel {
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME = "bestuser";
    public static final String PASSWORD = "bestuser";

    public static void main(String[] args) throws SQLException, InterruptedException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

//            statement.executeUpdate("update users set age = 5");


//            ResultSet set = statement.executeQuery("select * from users where id < 3");
//            while(set.next()){
//                System.out.println(set.getInt(3));
//            }

            ResultSet set = statement.executeQuery("select count(*) from users");
            while(set.next()){
                System.out.println(set.getInt(1));
            }


            new Trans().run();
            Thread.sleep(2000);

            ResultSet set2 = statement.executeQuery("select count(*) from users");
            while (set2.next()){
                System.out.println(set2.getInt(1));
            }

//            ResultSet set2 = statement.executeQuery("select * from users where id < 3");
//            while(set2.next()){
//                System.out.println(set2.getInt(3));
//            }

//            connection.rollback();

        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);

        } finally {
            connection.close();
        }
    }
    static class Trans extends Thread{

        @Override
        public void run() {
            try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()){

                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (name, age, email) values (?, ?, ?);");
                preparedStatement.setInt(2, 21);
                preparedStatement.setString(1, "Vika");
                preparedStatement.setString(3, "v@");
                preparedStatement.execute();
                connection.commit();
//                statement.executeUpdate("update users set age = 10");
//                connection.commit();

//                ResultSet resultSet = statement.executeQuery("select * from users");
//                while(resultSet.next()){
//                    System.out.println(resultSet.getString("age"));
//                }
//                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

