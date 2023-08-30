package com.danilermolenko.spring.project.dao.implementation;

import com.danilermolenko.spring.project.dao.AddressDao;
import com.danilermolenko.spring.project.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AddressDAO implements AddressDao {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public List<Address> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Address> addresses = session.createQuery("from Address").getResultList();
        session.close();
        return addresses;
    }

    @Override
    public Address findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address = session.get(Address.class, id);
        session.close();
        return address;
    }

    @Override
    public void save(Address address) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(address);
        session.close();
    }

    @Override
    public void update(Address address){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(address);
        session.close();
    }

    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Address> query = session.createQuery("delete Address where id =: addressId");
        query.setParameter("addressId", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
