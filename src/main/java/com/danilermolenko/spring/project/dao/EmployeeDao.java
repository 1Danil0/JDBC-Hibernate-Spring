package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll() throws SQLException;
    public Employee findById(long id) throws SQLException;
    public void save (Employee employee) throws SQLException;
    public void update (Employee employee, long id) throws SQLException;
    public void delete(long id) throws SQLException;
}
