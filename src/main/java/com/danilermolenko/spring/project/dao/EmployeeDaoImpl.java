package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Address;
import com.danilermolenko.spring.project.entity.Employee;
import com.danilermolenko.spring.project.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    private final Connector connector;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public EmployeeDaoImpl(Connector connector) {
        this.connector = connector;
    }
    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> allEmployees = new ArrayList<>();
        String sql = "select * from employees;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressId(resultSet.getLong("address_id"));
                allEmployees.add(employee);
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
        return allEmployees;
    }

    @Override
    public Employee findById(long id) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employees where id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            employee.setId(resultSet.getLong("id"));
            employee.setName(resultSet.getString("name"));
            employee.setSurname(resultSet.getString("surname"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressId(resultSet.getLong("address_id"));
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
        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql = "insert into employees (name, surname, birthday, address_id) values(?, ?, ?, ?);";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setDate(3, (java.sql.Date) employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressId());
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
    public void update(Employee employee, long id) throws SQLException {
        String sql = "update employees set name = ?, surname = ?, birthday = ?, address_id = ? where  id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setDate(3, (java.sql.Date) employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressId());
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
    public void delete(long id) throws SQLException {
        String sql = "delete from employees where id = ?;";
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
