package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(long id);
    public void save (Employee employee);
    public void update (Employee employee);
    public void delete(long id);
}
