package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Address;
import com.mysql.cj.result.AbstractDateTimeValueFactory;

import java.sql.SQLException;
import java.util.List;


public interface AddressDao {

    public List<Address> findAll() ;
    public Address findById(long id) ;
    public void save(Address address) ;
    public void update(Address address) ;
    public void deleteById(long id);
}
