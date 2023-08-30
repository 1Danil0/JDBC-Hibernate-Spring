package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Address;
import com.mysql.cj.result.AbstractDateTimeValueFactory;

import java.sql.SQLException;
import java.util.List;


public interface AddressDao {

    public List<Address> findAll() throws SQLException;
    public Address findById(long id) throws SQLException;
    public void save(Address address) throws SQLException;
    public void update(Address address, long id) throws SQLException;
    public void deleteById(long id) throws SQLException;
}
