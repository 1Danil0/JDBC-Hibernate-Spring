package com.danilermolenko.spring.project;

import com.danilermolenko.spring.project.dao.AddressDao;
import com.danilermolenko.spring.project.dao.EmployeeDao;
import com.danilermolenko.spring.project.dao.ProjectDao;
import com.danilermolenko.spring.project.dao.implementation.AddressDAO;
import com.danilermolenko.spring.project.dao.implementation.EmployeeDAO;
import com.danilermolenko.spring.project.dao.implementation.ProjectDAO;
import com.danilermolenko.spring.project.entity.Address;
import com.danilermolenko.spring.project.entity.Employee;
import com.danilermolenko.spring.project.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static AddressDao addressDao = new AddressDAO();
    private static ProjectDao projectDao = new ProjectDAO();
    private static EmployeeDao employeeDao = new EmployeeDAO();
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

//        Address address = new Address();
//        address.setCountry("1");
//        address.setCity("1");
//        address.setStreet("1");
//        address.setNumber(1);

//        Employee employee2 = new Employee();
//        employee2.setName("1");
//        employee2.setSurname("1");
//        employee2.setBirthday(Date.valueOf("2002-2-5"));
//        employee2.setAddress(address);
//
//        address.setEmployee(employee2);
//        Employee employee = new Employee();
//        employee.setName("2");
//        employee.setSurname("2");
//        employee.setBirthday(Date.valueOf("2001-8-21"));
//        employeeDao.save(employee);


//        Project project = new Project();
//        project.setTitle("Taro2");
//
//        employee2.addProject(project);
//        project.addEmployee(employee2);
//        employee2.addProject(project);
//
//        session.save(employee2);

//        addressDao.deleteById(1L);
//        List<Project> projects = projectDao.findAll();
//        System.out.println(projects);
//        List<Employee> employees = employeeDao.findAll();
//        System.out.println(employees);
//        for(Employee e: employees){
//            System.out.println(e.getAddress());
//            System.out.println(e.getProjectSet());
//        }
//        Employee employee = employeeDao.findById(3L);
//        employee.setAddress(address);
//        System.out.println(employee);
//        employee.setName("Danil");
//        employeeDao.update(employee2);
//        projectDao.save(project);
//        employeeDao.delete(1L);
//        addressDao.deleteById(1L);
//        projectDao.delete(3L);
//        addressDao.deleteById(1L);
//            addressDao.save(address);
//        session.getTransaction().commit();
//        session.close();
    }
}
