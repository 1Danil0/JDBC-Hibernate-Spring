package com.danilermolenko.spring.project.dao.implementation;

import com.danilermolenko.spring.project.dao.EmployeeDao;
import com.danilermolenko.spring.project.entity.Address;
import com.danilermolenko.spring.project.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO implements EmployeeDao {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee").getResultList();
        session.close();
        return employees;
    }

    @Override
    public Employee findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(employee);
        session.close();
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Address> query = session.createQuery("delete Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
