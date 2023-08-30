package com.danilermolenko.spring.test;


import java.sql.*;

public class App {
    public static final String URl = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME = "bestuser";
    public static final String PASSWORD = "bestuser";

    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URl, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("connected");
//            statement.executeUpdate("create table users (id int not null primary key auto_increment unique, name varchar(40) not null, age int, email varchar(40));");
//            statement.executeUpdate("insert into users (name, age, email) values ('Yasulya', 21, 'yasya');");
//            statement.executeUpdate("update users set age = 21, email = 'yasulya3' where id = 3");
//            statement.executeUpdate("insert into users (name, age, email) values ('Yasulya', 21, 'yasya');");
//            statement.executeUpdate("alter table users add column date date");
            String  id = "1";
            String name = "Yasulya";
            ResultSet resultSet = statement.executeQuery("select * from users where id = " + id);
//            while(resultSet.next()){
//                System.out.println(resultSet.getInt("age"));
//                System.out.println(resultSet.getString(2));
//                System.out.println("--------------------------------------------------------");
//            }

//            PreparedStatement statement1 = connection.prepareStatement("select * from users where name = ?");
//            statement1.setString(1, name);
//            resultSet = statement1.executeQuery();
            PreparedStatement statement1 = connection.prepareStatement("update users set date = {d ?} where id = ?");
            statement1.setDate(1, new Date(2023-8-29));
            statement1.setInt(2, 2);
            statement1.execute();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getDate("date"));
                System.out.println("--------------------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            connection.close();
        }
        System.out.println( "Hello World!" );
    }
}
