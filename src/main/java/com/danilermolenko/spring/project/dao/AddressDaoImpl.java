package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Address;
import com.danilermolenko.spring.project.util.Connector;
import com.mysql.cj.result.AbstractDateTimeValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao{
    private final Connector connector;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public AddressDaoImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public List<Address> findAll() throws SQLException {
        List<Address> list = new ArrayList<>();
        String sql = "select * from addresses;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setNumber(resultSet.getInt("number"));
                list.add(address);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return list;
    }

    @Override
    public Address findById(long id) throws SQLException {
        Address address = new Address();
        String sql = "select * from addresses where id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            address.setId(resultSet.getInt("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setNumber(resultSet.getInt("number"));
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return address;
    }

    @Override
    public void save(Address address) throws SQLException {
        String sql = "insert into addresses (country, city, street, number) values(?, ?, ?, ?);";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void update(Address address, long id) throws SQLException {
        String sql = "update addresses set country = ?, city = ?, street = ?, number = ? where  id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getNumber());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void deleteById(long id) throws SQLException {
        String sql = "delete from addresses where id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
