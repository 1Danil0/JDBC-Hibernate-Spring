package com.danilermolenko.spring.project;

import com.danilermolenko.spring.project.dao.*;
import com.danilermolenko.spring.project.entity.Address;
import com.danilermolenko.spring.project.entity.EmpProjConnector;
import com.danilermolenko.spring.project.entity.Employee;
import com.danilermolenko.spring.project.entity.Project;
import com.danilermolenko.spring.project.util.Connector;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    private static ProjectDao projectDao = new ProjectDaoImpl(new Connector());
    private static EmployeeDao employeeDao = new EmployeeDaoImpl(new Connector());
    private static AddressDao addressDao = new AddressDaoImpl(new Connector());
    private static EmpProjConnDao empProjConnDao = new EmpProjDaoConnImpl(new Connector());
    public static void main(String[] args) {
//        Address address = new Address();
//        address.setCountry("Turkey");
//        address.setCity("Stambul");
//        address.setStreet("myStreet");
//        address.setNumber(21);

        Employee employee = new Employee();
        employee.setId(2L);
        employee.setName("Yasya");
        employee.setSurname("Ermolenko");
        employee.setBirthday(Date.valueOf("2002-2-5"));
        employee.setAddressId(1);

//        Project project = new Project();
//        project.setTitle("IT");
//        EmpProjConnector connector = new EmpProjConnector();
//        connector.setEmployeeId(1);
//        connector.setProjectId(1);
        try {
            employeeDao.update(employee, employee.getId());
//            addressDao.save(address);
//            employeeDao.save(employee);
//            projectDao.save(project);
//            empProjConnDao.save(connector);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
